//package com.fistkim.producerapi
//
//import io.restassured.RestAssured
//import org.assertj.core.api.Assertions
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.web.server.LocalServerPort
//
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
//)
//class ProducerApiApplicationTests {
//
//    @LocalServerPort
//    var port = 0
//
//    @BeforeEach
//    fun setup() {
//        RestAssured.baseURI = "http://localhost:" + port
//    }
//
//    @Test
//    fun contextLoads() {
//        val request = RestAssured.given()
//
//        val response = RestAssured.given().spec(request)["/user"]
//        Assertions.assertThat(response.statusCode()).isEqualTo(200)
//
//        val responseBody = response.body.asString()
//        Assertions.assertThat(responseBody).isEqualTo("success")
//    }
//
//}
