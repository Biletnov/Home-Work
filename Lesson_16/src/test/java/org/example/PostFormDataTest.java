package org.example;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostFormDataTest {
    
    @Test
    public void testPostRequest() {
        String jsonBody = "{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}";
        
        given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }
}