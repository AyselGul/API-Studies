package get_http_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest05 {

    /* https://jsonplaceholder.typicode.com/todos/123 url’ine
content type’i “application/json” olan GET request’i yolladigimda
gelen response’un  status kodunun 200
 content type’inin “application/json”
Headers’daki “Server” in “cloudflare”
response body’deki “userId”’nin 7
“title” in “esse et quis iste est earum aut impedit”
“completed” bolumunun false oldugunu test edin
*/
    @Test
    public void test(){

      String jpholder="https://jsonplaceholder.typicode.com/todos/123";

        Response response= RestAssured.get(jpholder);

        response.prettyPrint();

        response.then().contentType(ContentType.JSON)
                .statusCode(200).headers("Server", equalTo("cloudflare"))
                .body("userId",equalTo(7),
                        "title",equalTo("esse et quis iste est earum aut impedit"),
                        "completed",equalTo(false));

    }
}
