package get_http_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


public class GetRequest01 {
    @Test
    public void test(){

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response=RestAssured.given().when().get(url);
       response.prettyPrint();

       System.out.println("status code : " + response.statusCode());
       System.out.println("contenType : "+ response.contentType());
       System.out.println("Test time : " + response.time());
       Assert.assertEquals(200,response.statusCode());
       Assert.assertEquals("application/json; charset=utf-8", response.contentType());

        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON);


    }
}
