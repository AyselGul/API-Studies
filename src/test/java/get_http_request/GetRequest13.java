package get_http_request;

import baseUrl.GMIBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest13 extends GMIBaseUrl {
      /*
    http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın
    "firstName": "Della",
    "lastName": "Heaney",
    "mobilePhoneNumber": "123-456-7893",
    "address": "75164 McClure Stream",
    "country" : "USA"
    "state": "New York43"
    "CREDIT_CARD",hesabında 69700$ ,
    "CHECKING" hesabında 11190$
     */
    @Test
    public void test(){
        spec03.pathParams("pm1","tp-customers","pm2","114351");
        Response response = RestAssured.given(spec03).
                header("Authorization","Bearer " + generateToken()).
                get("/{pm1}/{pm2}");

        // VERIFIED WITH MATCHERS CLASS

        response.then().body("firstName",equalTo("Della"),
                       "lastName",equalTo("Heaney"),
                               "mobilePhoneNumber",equalTo("123-456-7893"),
                               "address",equalTo("75164 McClure Stream"),
                               "country.name",equalTo("USA"),
                                "state" ,equalTo("New York43"),
                               "accounts[0].balance",equalTo("69700$"),
                                "accounts[1].balance",equalTo("11190$"));


        // VERIFIED WITH JSON PATH
        JsonPath js = response.jsonPath();

                  assertEquals("Della",js.getString("firstName"));
                  assertEquals("Heaney",js.getString("lastName"));
                  assertEquals("mobilePhoneNumber",js.getString("mobilePhoneNumber"));
                  assertEquals("75164 McClure Stream",js.getString("address"));
                  assertEquals("USA",js.getString("country.name"));
                  assertEquals("New York43",js.getString("state"));
                  assertEquals(  69700,js.getInt("accounts[0].balance"));
                  assertEquals( 11190,js.getInt("accounts[1].balance"));
    }


}
