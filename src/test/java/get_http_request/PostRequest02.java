package get_http_request;

import baseUrl.JsonPlaceholderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonplaceholderTestData;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class PostRequest02 extends JsonPlaceholderBaseUrl {
     /*
    https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
    {
    "userId": 55,
    "title": "Tidy your room",
    "completed": false
    }
    Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
    {
    "userId": 55,
    "title": "Tidy your room",
    "completed": false,
    "id": 201
    }
    */
     @Test
    public void test(){

         JsonplaceholderTestData jp= new JsonplaceholderTestData();
         JSONObject expectedPostData=jp.setupPostData();

         spec04.pathParam("prm1","todos");

         Response response= RestAssured.
                 given().
                 contentType(ContentType.JSON).
                 auth().
                 basic("admin","password123").
                 spec(spec04).body(expectedPostData.toString()).post("/{prm1}");


        // response.prettyPrint();

         // verifing with MATCHERS CLASS
         response.
                 then().
                 statusCode(expectedPostData.getInt("statuscode")).
                 body("completed",equalTo(expectedPostData.getBoolean("completed")),
                         "title",equalTo(expectedPostData.getString("title")),
                         "userId",equalTo(expectedPostData.getInt("userId")));


               // verifing with JSON PATH

         JsonPath js= response.jsonPath();
         Assert.assertEquals(expectedPostData.getInt("statuscode"),response.statusCode());
         Assert.assertEquals(expectedPostData.getBoolean("completed"),js.getBoolean("completed"));
         Assert.assertEquals(expectedPostData.getString("title"),js.getString("title"));
         Assert.assertEquals(expectedPostData.getInt("userId"),js.getInt("userId"));

         // verifing with DE-SERIALIZATION

         HashMap<String,Object> actualData= response.as(HashMap.class);
         Assert.assertEquals(expectedPostData.getBoolean("completed"),actualData.get("completed"));
         Assert.assertEquals(expectedPostData.getInt("statuscode"),actualData.get("statuscode"));
         Assert.assertEquals(expectedPostData.getString("title"),actualData.get("title"));
         Assert.assertEquals(expectedPostData.getInt("userId"),actualData.get("userId"));

     }
}
