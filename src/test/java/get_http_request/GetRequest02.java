package get_http_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetRequest02 {
    @Test
    public void test01(){

        String url = "https://reqres.in/api/users";

        Response response = RestAssured.given().get(url);
        response.prettyPrint();
        //response.prettyPeek();
        response.
                then().
                and().
                contentType(ContentType.JSON).
                statusCode(200).
                statusLine("HTTP/1.1 200 OK");

        response.then().body("data[0].first_name", equalTo("George"),
                         "data[0].last_name", equalTo("Bluth"),
                                 "data[0].email", equalTo("george.bluth@reqres.in"));

        response.then().body("data[1].id",equalTo(2),
                "data[1].email",equalTo("janet.weaver@reqres.in"),
                        "data[1].first_name",equalTo("Janet"),
                        "data[1].last_name",equalTo("Weaver"));

    }

}
