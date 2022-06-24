package get_http_request;

import baseUrl.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import testData.DummyTestData;

import static org.hamcrest.Matchers.equalTo;

public class DeleteRequest extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/delete/6 bir DELETE request gönderdiğimde
    Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
    {
    "status": "success",
    "data": "2",
    "message": "Successfully! Record has been deleted"
    }
   */

    @Test
    public void test(){
        spec02.pathParams("prm1","v1","prm2","delete","prm3","6");

               DummyTestData db= new DummyTestData();
               JSONObject expectedDeleteData= db.setupDelete();

        Response response = RestAssured.
                given().
                contentType(ContentType.JSON).
                auth().
                basic("admin","password123").
                spec(spec02).delete("/{prm1}/{prm2}/{prm3}");


        response.prettyPrint();

        // VERIFIED WITH MATCHERS CLASS
        response.then().
                statusCode(200).
                body("status", equalTo(expectedDeleteData.getString("status")),
                        "data",equalTo(expectedDeleteData.getString("data")),
                        "message",equalTo(expectedDeleteData.getString("message")));
    }
}
