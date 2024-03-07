package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutRequestTest {
    
    @Test
    public void testPutRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        
        given()
                .header("x-forwarded-proto", "https")
                .header("x-forwarded-port", "443")
                .header("host", "postman-echo.com")
                .header("x-amzn-trace-id", "Root=1-65e86a16-7ce79fdf0ba156a96721900e")
                .header("content-type", "text/plain")
                .header("user-agent", "PostmanRuntime/7.36.3")
                .header("accept", "*/*")
                .header("postman-token", "d0640be6-ea70-492f-92e8-1d9b81329d12")
                .header("accept-encoding", "gzip, deflate, br")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
