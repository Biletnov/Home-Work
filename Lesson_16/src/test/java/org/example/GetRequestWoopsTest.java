package org.example;
//Перейдите в сервис Postman (https://www.postman.com/postman/workspace/published-postman-templates/overview).
//Войдите в свой аккаунт и скачайте себе коллекцию Postman Echo.
//Написать автотесты для каждого метода из папки Request Methods
// (проверка тела ответа (просто сравнить значения всех полей) и кода ответа).

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestWoopsTest {
    
    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        
        Response response = given()
                .header("x-forwarded-proto", "https")
                .header("host", "postman-echo.com")
                .header("accept", "*/*")
                .header("accept-encoding", "gzip, deflate")
                .header("cache-control", "no-cache")
                .header("postman-token", "5c27cd7d-6b16-4e5a-a0ef-191c9a3a275f")
                .header("user-agent", "PostmanRuntime/7.6.1")
                .header("x-forwarded-port", "443")
                .get("/get?foo1=bar1&foo2=bar2");
        
        response.then()
                .assertThat()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}
