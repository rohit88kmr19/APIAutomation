package org.example.GET;

import io.restassured.RestAssured;

public class BDDSTYLE {
    public static void main(String[] args) {

            test1();
            test2();
    }

        public static void test1() {
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/250001")
                    .when().log().all()
                    .get()
                    .then().log().all()
                    .statusCode(200);
        }

        public static void test2() {
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/794102")
                    .when().log().all()
                    .get()
                    .then().log().all()
                    .statusCode(200);
        }

    }

