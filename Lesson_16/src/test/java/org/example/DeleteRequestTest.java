package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequestTest {
    
    @Test
    public void testDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        
        given()
                .header("accept", "*/*")
                .header("cache-control", "no-cache")
                .header("postman-token", "ff833eb3-9bc9-4ff5-8068-bca6e7f85de5")
                .header("accept-encoding", "gzip, deflate, br")
                .header("cookie", "sails.sid=s%3A-tymA6xssWACCc-pCxzq_KrZ1gjltiqV.he%2BU3JpRmz6P9WRfZSJWMsTVcDHAeL7blFA2PBR5dz0")
                .delete("/delete")
                .then()
                .assertThat()
                .statusCode(200);
    }
}