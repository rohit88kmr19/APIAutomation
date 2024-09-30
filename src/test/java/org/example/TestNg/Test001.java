package org.example.TestNg;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test001 {

    @Test
    public void test_get() {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/250001")
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }

}