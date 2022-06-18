package get_http_request;

import baseUrl.JsonPlaceholderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetRequest16 extends JsonPlaceholderBaseUrl {


       /*
   https://jsonplaceholder.typicode.com/todos/7
   {
   "userId": 1,
   "id": 7,
   "title": "illo expedita consequatur quia in",
   "completed": false
}
    */

    @Test
    public void test(){
        spec04.pathParams("prm1","todos","prm2",7);

        // FORM in MAP-STRUCTURED EXPECTED DATA

        Map<String,Object> expectedData=new HashMap<>();

        expectedData.put("userId",1);
        expectedData.put("id",7);
        expectedData.put("title","illo expedita consequatur quia in");
        expectedData.put("completed",false);
        System.out.println("ExpectedData : " + expectedData);

        Response response = RestAssured.given().spec(spec04).get("/{prm1}/{prm2}");
        response.prettyPrint();

            // FORM in MAP-STRUCTURED ACTUAL DATA
        Map<String,Object> actualData= response.as(HashMap.class);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));

    }
}
