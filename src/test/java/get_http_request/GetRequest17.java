package get_http_request;

import baseUrl.GMIBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest17 extends GMIBaseUrl {
     /*
       http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın
    {
       "firstName": "Della",
       "lastName": "Heaney",
       "email": "ricardo.larkin@yahoo.com",
       "mobilePhoneNumber": "123-456-7893",
    }
    */

    @Test
    public void test01(){
        spec03.pathParams("prm1","tp-customers","prm2","114351");

        Response response = RestAssured.given().
                spec(spec03).
                header("Authorization","Bearer " + generateToken()).get("/{prm1}/{prm2}");

        Map<String,Object> expectedData= new HashMap<>();

        expectedData.put("firstName","Della");
        expectedData.put("lastName","Heaney");
        expectedData.put("email","ricardo.larkin@yahoo.com");
        expectedData.put("mobilePhoneNumber","123-456-7893");

        Map<String,Object> actualData= response.as(Map.class);

        assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
        assertEquals(expectedData.get("email"),actualData.get("email"));
        assertEquals(expectedData.get("mobilePhoneNumber"),actualData.get("mobilePhoneNumber"));
        System.out.println(actualData);


    }
}
