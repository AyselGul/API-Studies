package get_http_request;

import baseUrl.JsonPlaceholderBaseUrl;
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

public class GetRequest20 extends JsonPlaceholderBaseUrl {
     /*
   https://jsonplaceholder.typicode.com/todos/2

   1) Status kodunun 200,
   2) respose body'de,
            "completed": false
            "title”: “quis ut nam facilis et officia qui”
            "userId" 1 ve
             header değerlerinden
            "via" “1.1 vegur” ve
            "Server" “cloudflare” olduğunu test edin…

   */
@Test
    public void test01(){
    spec04.pathParams("prm1","todos","prm2",2);
    Response response = RestAssured.given().spec(spec04).get("/{prm1}/{prm2}");

    // System.out.println(response.prettyPrint());


    // De- Serialization

// Form EXPECTED DATA

    Map<String, Object> expectedData= new HashMap<>();

    expectedData.put("completed", false);
    expectedData.put("title", "quis ut nam facilis et officia qui");
    expectedData.put("userId", 1);
    expectedData.put("via", "1.1 vegur");
    expectedData.put("Server", "cloudflare");
    expectedData.put("statusCode", 200);
    expectedData.put("id", 2);


// Form ACTUAL DATA

    Map<String,Object> actualData = response.as(Map.class);

    assertEquals(expectedData.get("completed"),actualData.get("completed"));
    assertEquals(expectedData.get("title"),actualData.get("title"));
    assertEquals(expectedData.get("userId"),actualData.get("userId"));
    assertEquals(expectedData.get("id"),actualData.get("id"));




    // VERIFIED WITH JSON PATH
    JsonPath js = response.jsonPath();
    assertEquals(expectedData.get("statusCode"),response.statusCode());
    assertEquals(expectedData.get("via"),response.getHeader("via"));
    assertEquals(expectedData.get("Server"),response.getHeader("Server"));
    assertEquals(expectedData.get("userId"),js.getInt("userId"));
    assertEquals(expectedData.get("title"),js.getString("title"));
    assertEquals(expectedData.get("id"),js.getInt("id"));
    assertEquals(expectedData.get("completed"),js.getBoolean("completed"));

    // VERIFIED WITH MATCHERS CLASS
    response.then()
            .statusCode((Integer) expectedData.get("statusCode"))
            .headers("via", equalTo(expectedData.get("via")),
                    "Server", equalTo(expectedData.get("Server")))
            .body("userId", equalTo(expectedData.get("userId")),
                    "title", equalTo(expectedData.get("title")),
                    "id", equalTo(expectedData.get("id")),
                    "completed", equalTo(expectedData.get("completed")));



}
}
