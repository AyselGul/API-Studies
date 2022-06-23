package get_http_request;

import baseUrl.HerokuappBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.HerokuappTestData;

import java.util.HashMap;
import java.util.Map;

public class GetRequest22 extends HerokuappBaseUrl {
      /*
   https://restful-booker.herokuapp.com/booking/47
          {
              "firstname": "Ali",
              "lastname": "Can",
              "totalprice": 500,
              "depositpaid": true,
              "bookingdates": {
                                "checkin": "2022-02-01",
                                 "checkout": "2022-02-11"
             }
          }
   1) JsonPhat
   2) De-Serialization
   */
    @Test
    public void test(){
      spec05.pathParams("prm1","booking","prm2",47);

        HerokuappTestData hrk = new HerokuappTestData();

        HashMap<String,Object> expectedData= hrk.setupTestData();

         System.out.println(expectedData);
        Response response = RestAssured.given().spec(spec05).get("/{prm1}/{prm2}");

        // response.prettyPrint();

        // DE-SERIALIZATION
         HashMap<String,Object> actualData= response.as(HashMap.class);
        System.out.println(actualData);

        Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
       Assert.assertEquals(expectedData.get("totalPrice"),actualData.get("totalPrice"));
        Assert.assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),
                ((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map) expectedData.get("bookingdates")).get("checkout"),
                ((Map) actualData.get("bookingdates")).get("checkout"));



        // JSON PATH
       JsonPath js= response.jsonPath();
       Assert.assertEquals(expectedData.get("firstname"),js.getString("firstname"));
       Assert.assertEquals(expectedData.get("lastname"),js.getString("lastname"));
       Assert.assertEquals(expectedData.get("totalPrice"),js.getInt("totalPrice"));
       Assert.assertEquals(expectedData.get("depositpaid"),js.getBoolean("depositpaid"));
       Assert.assertEquals(expectedData.get("additionalneeds"),js.getString("additionalneeds"));
        Assert.assertEquals(((HashMap) expectedData.get("bookingdates")).get("checkin")
                , js.getString("bookingdates.checkin"));
        Assert.assertEquals(((HashMap) expectedData.get("bookingdates")).get("checkout")
                , js.getString("bookingdates.checkout"));

    }

}
