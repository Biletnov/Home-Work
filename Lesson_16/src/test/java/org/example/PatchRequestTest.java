package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRequestTest {
    
    @Test
    public void testPatchRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        
        Response response = given()
                .header("x-forwarded-proto", "https")
                .header("x-forwarded-port", "443")
                .header("host", "postman-echo.com")
                .header("x-amzn-trace-id", "Root=1-62692cd9-0c0522db189f4ace45f96b58")
                .header("content-type", "text/plain")
                .header("user-agent", "PostmanRuntime/7.29.0")
                .header("accept", "*/*")
                .header("cache-control", "no-cache")
                .header("postman-token", "e0327d6d-66b1-4009-a95f-95c41177b9cb")
                .header("accept-encoding", "gzip, deflate, br")
                .header("cookie", "sails.sid=s%3AaaxVxsGuRjCno-7IVEL6AlUt-cvSw9E8.HkNgHa0ueHT%2Bi4zTwlWcE4wG3nR78igzwuXmv4zmMtc")
                .body("This is expected to be sent back as part of response body.")
                .patch("/patch");
        
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
