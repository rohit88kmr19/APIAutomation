package org.example.E2E;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseIntegration {

    //  Create a Token
    // Create a Booking
    //  Perform  a PUT request
    //  Verify that PUT is success by GET Request
    // Delete the ID
    // Verify it doesn't exist GET Request

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;

    @BeforeTest
    public String Test001_getToken() {
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

        token=response.jsonPath().getString("token");
        System.out.println("Token Generated with POST" +token);

        return token;
    }
    @BeforeTest
    public String Test002_getBookingID()
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
        bookingId = response.jsonPath().getString("bookingid");
            return bookingId;
    }
    @Test(priority = 1)
    public void test_update_request_put() {

//        token = Test001_getToken();
//        bookingId= Test002_getBookingID();

        String payloadPUT= "{\n" +
                "    \"firstname\" : \"Anshul\",\n" +
                "    \"lastname\" : \"Ji\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId); // I was picking wring URL
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
    @Test(priority =2)
    public void test_update_request_get() {

        System.out.println("Booking Id by using Get Request"+bookingId);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId); // I was picking wring URL
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().get();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }

    @Test(priority =3)
    public void test_delete_booking() {
        System.out.println("Token received to delete the booking id"+token);
        System.out.println("Booking id to delete"+bookingId);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId); // I was picking wring URL
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        Response response = requestSpecification.when().delete();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);


    }

    @Test(priority = 4)
    public void test_get_Deleted_ID() {
        System.out.println("Deleted Booking Id by using Get"+bookingId);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId); // I was picking wring URL
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.when().get();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);
    }
}
