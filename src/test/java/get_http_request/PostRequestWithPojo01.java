package get_http_request;

import baseUrl.JsonPlaceholderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.TodosPojo;

import static org.junit.Assert.assertEquals;

public class PostRequestWithPojo01 extends JsonPlaceholderBaseUrl {

       /*
    https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
    Request body{
    "userId": 21,
    "id": 201,
    "title": "Tidy your room",
    "completed": false
    }
    Status kodun 201, response body ‘nin ise
    {
    "userId": 21,
    "id": 201,
    "title": "Tidy your room",
    "completed": false
    }
    */
    @Test
    public void test(){
      spec04.pathParam("prm1","todos");

        TodosPojo requestExpectedData = new TodosPojo(21,201,"Tidy your room",false);
        System.out.println(requestExpectedData);

        Response response= RestAssured.
                given().
                contentType(ContentType.JSON).
                auth().
                basic("admin","password123").
                spec(spec04).
                body(requestExpectedData).post("/{prm1}");

               // response.prettyPrint();


              // DE-SERIALIZATION WITH POJO

        TodosPojo actualData= response.as(TodosPojo.class);

        assertEquals(201,response.statusCode());
        assertEquals(requestExpectedData.getUserId(),actualData.getUserId());
        assertEquals(requestExpectedData.getId(),actualData.getId());
        assertEquals(requestExpectedData.getTitle(),actualData.getTitle());
        assertEquals(requestExpectedData.isCompleted(),actualData.isCompleted());



    }
}
