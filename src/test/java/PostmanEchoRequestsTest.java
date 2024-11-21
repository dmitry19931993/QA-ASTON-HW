import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoRequestsTest {

    @Test
    public void testPostmanEchoGetRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .extract()
                .response();

        System.out.println(response.asString());
    }

    @Test
    public void testPostmanEchoPostRawTextRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .extract()
                .response();

        System.out.println(response.asString());
    }

    @Test
    public void testPostmanEchoPostFormDataRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .extract()
                .response();

        System.out.println(response.asString());
    }

    @Test
    public void testPostmanEchoPutRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .extract()
                .response();

        System.out.println(response.asString());
    }

    @Test
    public void testPostmanEchoPatchRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .extract()
                .response();

        System.out.println(response.asString());
    }

    @Test
    public void testPostmanEchoDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .extract()
                .response();

        System.out.println(response.asString());
    }
}
