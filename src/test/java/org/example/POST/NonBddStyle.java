package org.example.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBddStyle {

    public static void main(String[] args) {

        String payload1 = "{\n" +
                "                \"username\" : \"admin\",\n" +
                "                \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload1);

        Response response = r.when().post();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }
}
