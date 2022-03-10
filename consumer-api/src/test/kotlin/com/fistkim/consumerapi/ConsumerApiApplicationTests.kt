package com.fistkim.consumerapi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
    ids = ["com.fistkim:producer-api:+:stubs:8090"],
    stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
class ConsumerApiApplicationTests {

    lateinit var client: WebTestClient

    @BeforeEach
    fun init() {
        client = WebTestClient
            .bindToServer()
            .baseUrl("http://localhost:" + 8090)
            .build()
    }

    @Test
    fun successTest() {
        client.get().uri("/user")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .consumeWith {
                val result = String(it.responseBody!!)
                Assertions.assertEquals("success", result)
            }
    }
}
