package org.example.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class Test01Asser {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void testPost()
    {
        String payload2= "{\n" +
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
        requestSpecification.basePath("/booking/"); // I was picking wring URL
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.cookie("token",token);
        requestSpecification.body(payload2).log().all();

        Response response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Below RestAssured Matchers - Hamcrest Assertions.
//        validatableResponse.body("booking.firstname", Matchers.equalTo("Sonu"));
//        validatableResponse.body("booking.lastname", Matchers.equalTo("kumar"));
//        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
//        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.time(greaterThanOrEqualTo(2000L));
        validatableResponse.header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"));
        validatableResponse.header("Content-Length", Matchers.equalTo("196"));


        bookingId = response.then().extract().path("bookingid");
        System.out.println(bookingId);
        String firstname=response.then().extract().path("booking.firstname");
        System.out.println(firstname);
        String contentType = response.then().extract().header("Content-Type");
        String contentLength = response.then().extract().header("Content-Length");
        System.out.println("Content-Type is: " + contentType);
        System.out.println("Content-Length is: " + contentLength);
        //int responseTime = response.then().extract().path("responseTime");
//
//        Below TestNg Assertions
//        Assert.assertNotNull(bookingId);
//        Assert.assertEquals(firstname,"Sonu");

        //AssertJ below code
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Sonu").isNotEmpty().isNotBlank();

        String s = ""; //Empty
        String s2 = " ";//Blank - It contains whitespaces.

//        bookingId = response.jsonPath().getString("bookingid");
//        System.out.println("The booking id is:---" +bookingId);
    }


}

