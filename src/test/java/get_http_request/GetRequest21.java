package get_http_request;

import baseUrl.JsonPlaceholderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonplaceholderTestData;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class GetRequest21 extends JsonPlaceholderBaseUrl {
        /*
   https://jsonplaceholder.typicode.com/todos/2

   1) Status kodunun 200,
   2) respose body'de,
            "completed": false
            "title”: “quis ut nam facilis et officia qui”
            " id=2"
            "userId" 1 ve
             header değerlerinden
            "via" “1.1 vegur” ve
            "Server" “cloudflare” olduğunu test edin…

   */
    @Test
    public void test(){

        spec04.pathParams("prm1","todos","prm2",2);

        JsonplaceholderTestData expectedDataobj = new JsonplaceholderTestData();

        HashMap<String,Object> expectedData  =expectedDataobj.setupTestData();
        System.out.println(expectedData);

        Response response = RestAssured.given().spec(spec04).when().get("/{prm1}/{prm2}");

        HashMap<String,Object> actualData = response.as(HashMap.class);

        // Matchers Class


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
