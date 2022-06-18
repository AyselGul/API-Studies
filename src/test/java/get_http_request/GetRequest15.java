package get_http_request;

import baseUrl.GMIBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest15 extends GMIBaseUrl {

      /*
    https://www.gmibank.com/api/tp-customers/85694
    "login": "dino.kohler",
    "firstName": "Winona",
    "lastName": "Abernathy",
     "email": "winonaabernathy@gmail.com"
     */

    @Test
    public void test(){
        spec03.pathParams("pm1","tp-customers","pm2","110472");
        Response response = RestAssured.given(spec03).
                header("Authorization","Bearer " + generateToken()).
                get("/{pm1}/{pm2}");



        // VERIFIED WITH JSON PATH
        JsonPath js = response.jsonPath();

        assertEquals("Melva",js.getString("user.firstName"));
        assertEquals("Abernathy",js.getString("user.lastName"));
        assertEquals("winonaabernathy@gmail.com",js.getString("user.email"));
        assertEquals("dino.kohler",js.getString("user.login"));

        // VERIFIED WITH MATCHERS CLASS

        response.then().body("user.firstName",equalTo("Melva"),
                "user.lastName",equalTo("Abernathy"),
                "user.email",equalTo("winonaabernathy@gmail.com"),
                  "user.login",equalTo("dino.kohler"));




    }

}
