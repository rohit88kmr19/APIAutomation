package org.example.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BddStyle {

    public static void main(String[] args) {

        String payload = "{\n" +
                "                \"username\" : \"admin\",\n" +
                "                \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON).log().all()
                .body(payload)
                .when()
                .post()
                .then().log().all()
                .statusCode(201);



    }




}
