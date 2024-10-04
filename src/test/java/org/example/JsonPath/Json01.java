package org.example.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Json01 {
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
        requestSpecification.body(payload2);

        Response response = requestSpecification.when().post();

        System.out.println("the response is:-->" +response.asString());

        JsonPath jsonPath= new JsonPath(response.asString());
        String bookingId  = jsonPath.getString("bookingid");
        String firstname  = jsonPath.getString("booking.firstname");
        String checkout  = jsonPath.getString("booking.bookingdates.checkout");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkout);

        // Below AssertJ Assertion.
        assertThat(bookingId).isNotNull().isNotBlank().isGreaterThan("0");
        assertThat(firstname).isNotNull().isNotBlank().isEqualTo("Sonu");
        assertThat(checkout).isNotNull().isNotBlank();

        Assert.assertEquals(firstname,"Sonu"); // TestNG Assertion



        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }
    }