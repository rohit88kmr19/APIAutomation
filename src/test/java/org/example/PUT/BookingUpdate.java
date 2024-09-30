package org.example.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BookingUpdate {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    @Test
    public void test_put_positive_tc(){
        // POST - Auth - token

        String token  = "ba55f4688fd25d3";
        String bookingid = "1239";

        String payloadPut1= "{\n" +
                "    \"firstname\" : \"Sonu\",\n" +
                "    \"lastname\" : \"kumar\",\n" +
                "    \"totalprice\" : 2000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2019-01-01\",\n" +
                "        \"checkout\" : \"2014-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Foodie\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid); // I was picking wring URL
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPut1).log().all();

        Response response = requestSpecification.when().put();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
}


    }
