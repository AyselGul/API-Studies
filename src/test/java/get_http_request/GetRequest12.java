package get_http_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

public class GetRequest12 extends Authentication {
    String endPoint = "http://www.gmibank.com/api/tp-customers";

    @Test
    public void test01(){

        Response response = RestAssured.given().
                header("Authorization","Bearer " + generateToken()).
                get(endPoint).
                then().
                extract().
                response();
        response.prettyPrint();
        response.then().contentType(ContentType.JSON).statusCode(200);



    }
}
