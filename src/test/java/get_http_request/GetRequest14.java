package get_http_request;

import baseUrl.GMIBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest14 extends GMIBaseUrl {

     /*
    http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın
    "firstName": "Melva",
    "lastName": "Bernhard",
    "email": "chas.kuhlman@yahoo.com"
    "zipCode": "40207"
    "country" "name": "San
    "login": "delilah.metz"
     */
    @Test
    public void test(){
        spec03.pathParams("pm1","tp-customers","pm2","110472");
        Response response = RestAssured.given(spec03).
                header("Authorization","Bearer " + generateToken()).
                get("/{pm1}/{pm2}");


        // VERIFIED WITH MATCHERS CLASS

        response.then().body("firstName",equalTo("Melva"),
                "lastName",equalTo("Bernhard"),
                "email",equalTo("chas.kuhlman@yahoo.com"),
                "zipCode",equalTo("40207"),
                "country.name",equalTo("San Jose"),
                "user.login",equalTo("delilah.metz"));

        // VERIFIED WITH JSON PATH
        JsonPath js = response.jsonPath();

        assertEquals("Melva",js.getString("firstName"));
        assertEquals("Bernhard",js.getString("lastName"));
        assertEquals("40207",js.getString("zipCode"));
        assertEquals("chas.kuhlman@yahoo.com",js.getString("email"));
        assertEquals("San Jose",js.getString("country.name"));
        assertEquals("delilah.metz"  ,js.getString("user.login"));

    }



}
