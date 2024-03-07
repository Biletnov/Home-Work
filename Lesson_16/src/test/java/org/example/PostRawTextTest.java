package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRawTextTest {
    
    @Test
    public void testPostRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        
        String requestBody = "This is expected to be sent back as part of response body.";
        
        Response response = given()
                .header("x-forwarded-proto", "https")
                .header("x-forwarded-port", "443")
                .header("host", "postman-echo.com")
                .header("x-amzn-trace-id", "Root=1-62692504-2637ebc016fc39d20779c3ab")
                .header("content-type", "text/plain")
                .header("user-agent", "PostmanRuntime/7.29.0")
                .header("accept", "*/*")
                .header("cache-control", "no-cache")
                .header("postman-token", "4a108912-d4a0-4bdb-8f21-c12818ed681d")
                .header("accept-encoding", "gzip, deflate, br")
                .header("cookie", "sails.sid=s%3A6AxJen4Bb37BqnTVLlDQT_kb_X5F87RW.6Hygsj5yGRsr0bSdYx2o0fPNjN4ZN4YbZEH3iRIBCRg")
                .body(requestBody)
                .post("/post");
        
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo(requestBody));
    }
}