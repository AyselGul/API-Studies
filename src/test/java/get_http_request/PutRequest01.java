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

public class PutRequest01 extends JsonPlaceholderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body'İ PUT ettiğinizde
    {
    "userId": 21,
    "title": "Wash the dishes",
    "completed": false
    }
    Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
    {
    "userId": 21,
    "title": "Wash the dishes",
    "completed": false,
    "id": 198
    }
    */
    @Test
    public void test(){
        spec04.pathParams("prm1","todos","prm2","198");

        JsonplaceholderTestData jsonplaceholderTestData= new JsonplaceholderTestData();
       JSONObject expectedPutData= jsonplaceholderTestData.setupPutData();

        Response response = RestAssured.
                given().
                contentType(ContentType.JSON).
                spec(spec04).
                auth().
                basic("admin","password123").body(expectedPutData.toString()).put("/{prm1}/{prm2}");
        response.prettyPrint();

        // verifing with JSON PATH

        JsonPath js = response.jsonPath();
        Assert.assertEquals(expectedPutData.getInt("userId"),js.getInt("userId"));
        Assert.assertEquals(expectedPutData.getBoolean("completed"),js.getBoolean("completed"));
        Assert.assertEquals(expectedPutData.getString("title"),js.getString("title"));
        Assert.assertEquals(200,response.statusCode());

    }
}
