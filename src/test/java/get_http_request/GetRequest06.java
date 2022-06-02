package get_http_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetRequest06 {
    /*
    https://restful-booker.herokuapp.com/booking/11 url’ine
        accept type’i “application/json” olan GET request’i yolladigimda
        gelen response’un
        status kodunun 200
        ve content type’inin “application/json”
        ve firstname’in “James”
        ve totalprice’in 111
        ve checkin date’in "2018-01-01"   oldugunu test edin
     */
    @Test
    public void test(){

        String herokuApp="https://restful-booker.herokuapp.com/booking/11";
        Response response = RestAssured.get(herokuApp);
        response.prettyPrint();

        response.then().
                contentType(ContentType.JSON).
                statusCode(200).
                body("firstname", equalTo("James"),
                        "totalprice",equalTo(111),
                        "bookingdates.checkin",equalTo("2018-01-01"));
    }
}
