package get_http_request;

import baseUrl.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


public class GetRequest09 extends DummyBaseUrl {
    /*
      http://dummy.restapiexample.com/api/v1/employee/12         URL'E GiT.
      1) Matcher CLASS ile
      2) JsonPath ile dogrulayin.
    */
    @Test
    public void test() {
        spec02.pathParams("pm1", "v1", "pm2", "employee", "pm3", "12");

        Response response = RestAssured.given().spec(spec02).get("/{pm1}/{pm2}/{pm3}");
        response.prettyPrint();


        //  VERIFY WITH MATCHERS CLASS
      response.then().body("data.id", equalTo(12),
              "data.employee_name", equalTo("Quinn Flynn"),
              "data.employee_salary", equalTo(342000),
              "data.employee_age", equalTo(22),
              "data.profile_image", equalTo(""));

      // VERIFY WITH JSONPATH

        JsonPath js= response.jsonPath();

                assertEquals(12,js.getInt("data.id"));
                assertEquals ("Quinn Flynn",js.getString("data.employee_name"));
                assertEquals(342000,js.getInt("data.employee_salary"));
                assertEquals(22,js.getInt("data.employee_age"));
                assertEquals("",js.getString("data.profile_image"));


    }
}