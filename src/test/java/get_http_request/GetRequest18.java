package get_http_request;

import baseUrl.GMIBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest18 extends GMIBaseUrl {
 /*
           http://www.gmibank.com/api/tp-customers/43703
           "firstName": "Alda",
           "lastName": "Monahan",
           "middleInitial": "Nichelle Hermann Kohler",
           "email": "com.github.javafaker.Name@7c011174@gmail.com",
           "mobilePhoneNumber": "909-162-8114",
           "city": "St Louis",
           "ssn": "108-53-6655"

           1) MATCHERS CLASS
           2) JSON PATH
           3) De-Serialization
     */
    @Test
    public void test(){
        spec03.pathParams("prm1","tp-customers","prm2","43703");

        Response response = RestAssured.given().
                spec(spec03).
                header("Authorization","Bearer " + generateToken()).get("/{prm1}/{prm2}");

        // Matchers Class

        response.then().body("firstName",equalTo("Alda"),
                        "lastName",equalTo("Monahan"),
                                "middleInitial",equalTo("Nichelle Hermann Kohler"),
                                "email",equalTo("com.github.javafaker.Name@7c011174@gmail.com"),
                                "mobilePhoneNumber",equalTo("909-162-8114"),
                                 "city",equalTo("St Louis"),
                                "ssn",equalTo("108-53-6655"));

                Map<String,Object> expectedData= new HashMap<>();

                expectedData.put("firstName","Alda");
                expectedData.put("lastName","Monahan");
                expectedData.put("middleInitial","Nichelle Hermann Kohler");
                expectedData.put("email","com.github.javafaker.Name@7c011174@gmail.com");
                expectedData.put("mobilePhoneNumber","909-162-8114");
                expectedData.put("city","St Louis");
                expectedData.put("ssn","108-53-6655");


                Map<String,Object> actualData = response.as(Map.class);

                // De- Serialization

              Assert.assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
              Assert.assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
              Assert.assertEquals(expectedData.get("middleInitial"),actualData.get("middleInitial"));
              Assert.assertEquals(expectedData.get("email"),actualData.get("email"));
              Assert.assertEquals(expectedData.get("mobilePhoneNumber"),actualData.get("mobilePhoneNumber"));
              Assert.assertEquals(expectedData.get("city"),actualData.get("city"));
              Assert.assertEquals(expectedData.get("ssn"),actualData.get("ssn"));

                // JSON PATH

        JsonPath jsonPath=response.jsonPath();
       assertEquals("Alda", jsonPath.getString("firstName"));
       assertEquals("Monahan", jsonPath.getString("lastName"));
       assertEquals("middleInitial", jsonPath.getString("Nichelle Hermann Kohler"));
       assertEquals("email", jsonPath.getString("com.github.javafaker.Name@7c011174@gmail.com"));
       assertEquals("mobilePhoneNumber", jsonPath.getString("909-162-8114"));
       assertEquals("city", jsonPath.getString("St Louis"));
       assertEquals("ssn", jsonPath.getString("108-53-6655"));


    }
}
