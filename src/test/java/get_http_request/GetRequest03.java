package get_http_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {
    @Test
    public void test() {
          /*
    https://restful-booker.herokuapp.com/booking/7 url'ine GET request'i yolladigimda
    gelen response'un status kodunun 200 ve content type'inin "application/json"
            firstname'in "Sally"
            lastname'in "Smith"
            checkin date'in "2022-01-03"
             checkout date'in "2022-03-10" oldugunu test edin
     */
        String url = "https://restful-booker.herokuapp.com/booking/7";

        Response response = RestAssured.get(url);
        // response.prettyPrint();
        response.
                then().
                contentType(ContentType.JSON).
                statusCode(200).
                body("firstname", equalTo("Sally"),
                        "lastname", equalTo("Smith"),
                        "bookingdates.checkin", equalTo("2022-01-03"),
                        "bookingdates.checkout", equalTo("2022-03-10"));

    }
}