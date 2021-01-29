package org.acme;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MyRouteBuilderTest {

    @Test
    public void printConfigsShouldSucceed() {
        get("/print-configs").then().statusCode(200);
    }

}
