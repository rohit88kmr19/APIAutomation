package org.example.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NONBDDSTYLE {

    static RequestSpecification r = RestAssured.given();
    public static void main(String[] args) {
        r.baseUri("https://api.zippopotam.us");
        testnbdd1();
        testnbdd2();

    }

    private static void testnbdd1() {

        r.basePath("/IN/250001");
        r.when().get();
        r.then().log().all().statusCode(200);
    }

    private static void testnbdd2() {
        r.basePath("/IN/794102");
        r.when().get();
        r.then().log().all().statusCode(200);
    }
}
