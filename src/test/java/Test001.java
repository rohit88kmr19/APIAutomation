import io.restassured.RestAssured;

public class Test001 {
    public static void main(String[] args) {
        System.out.println("Rest Assured Test Cases");
        System.out.println("Get Request");

        //Given -URL, headers, body or payload
        //When - Http methods- get, post, pu etc
        // Then - Verify the response

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("booking/1").log().all()
                .when()
                .get()
                .then().log().all()
                .statusCode(200);

    }
}
