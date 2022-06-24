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

public class PatchRequest extends JsonPlaceholderBaseUrl {
 /*
 https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
 {
  "title": "Batch44"
 }
 Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
 {
 "userId": 10,
 "title": "Batch44"
 "completed": true,
 "id": 198
 }
 */

    @Test
    public void test(){
        spec04.pathParams("prm1","todos","prm2","198");

        JsonplaceholderTestData jcp = new JsonplaceholderTestData();

        JSONObject expectedPatchData=jcp.setupPatchData();
        JSONObject expectedRequestData=jcp.setupPatchRequestData();

        // System.out.println(expectedPatchData);
        // System.out.println(expectedRequestData);

        Response response = RestAssured.given().
                contentType(ContentType.JSON).
                auth().
                basic("admin","password123").
                spec(spec04).
                body(expectedRequestData.toString()).
                patch("/{prm1}/{prm2}");
        response.prettyPrint();



        JsonPath js= response.jsonPath();


        Assert.assertEquals(expectedPatchData.getInt("userId" ),js.getInt("userId"));
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedPatchData.getString("title" ),js.getString("title"));
        Assert.assertEquals(expectedPatchData.getBoolean("completed" ),js.getBoolean("completed"));
        Assert.assertEquals(expectedPatchData.getInt("id" ),js.getInt("id"));

    }

}
