package org.ekosutrisno;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/v1")
          .then()
             .statusCode(200);
    }

}