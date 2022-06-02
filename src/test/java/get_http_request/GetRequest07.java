package get_http_request;

import baseUrl.ReqresinBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest07 extends ReqresinBaseUrl {

       /*
       https://reqres.in/api/users URL request olustur.
       body icerisindeki id si 5 olan datayi
       1) Matcher CLASS ile
       2) JsonPath ile dogrulayin.
      */

    @Test
    public void test(){
      spec01.pathParams("pm1","api", "pm2","users");
        Response response= RestAssured.given().spec(spec01).get("/{pm1}/{pm2}");
        //  "/{pm1}/{pm2}" ---> /api/users

       response.prettyPrint();


       response.then().body("data[4].id",equalTo(5),
                                    "data[4].email", equalTo("charles.morris@reqres.in"),
                                     "data[4].first_name", equalTo("Charles"),
                                      "data[4].last_name", equalTo("Morris"));         // verifying with  Matchers Class


        JsonPath js=response.jsonPath();


        assertEquals(5,js.getInt("data[4].id"));
        assertEquals("charles.morris@reqres.in",js.getString("data[4].email"));
        assertEquals("Charles",js.getString("data[4].first_name"));
        assertEquals("Morris",js.getString("data[4].last_name"));


    }
}
