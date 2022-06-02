package get_http_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class GetRequest04 {
        /*
http://dummy.restapiexample.com/api/v1/employees  url'ine
 GET request'i yolladigimda gelen response'un
 status kodunun 200 ve content type'inin "application/json"
ve employees sayisinin 24
ve employee'lerden birinin "Ashton Cox"
ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.

 */

    @Test
    public void test(){

        String dummyUrl="http://dummy.restapiexample.com/api/v1/employees";

        Response response= RestAssured.get(dummyUrl);
        response.prettyPrint();
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data",hasSize(24),
                        "data.employee_name",hasItem("Ashton Cox"),
                                "data.employee_age",hasItems(21,61,23));
    }
}
