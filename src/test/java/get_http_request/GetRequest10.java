package get_http_request;

import baseUrl.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest10 extends DummyBaseUrl {
            /*
                   http://dummy.restapiexample.com/api/v1/employees  url'ine
                   GET request'i yolladigimda gelen response'un
                   status kodunun 200 ve content type'inin "application/json"
                   toplam calisanin 24 oldugunu
                   5.calisanin isminin "Airi Satou"
                   6. calisanin maasinin "372000"
                   "Rhona Davidson" in calisanlardan birisi oldugunu
                   "21","23","61" yaslarinda employerlar oldugunu test edin
                   */
    @Test
    public void test(){

        spec02.pathParams("pm1","v1","pm2","employees");

           Response response = RestAssured.given().spec(spec02).get("/{pm1}/{pm2}");
           // response.prettyPrint();
           response.then().statusCode(200).contentType(ContentType.JSON);

           JsonPath js = response.jsonPath();
           assertEquals("Airi Satou",js.getString("data[4].employee_name"));
           assertEquals(372000,js.getInt("data[5].employee_salary"));
           assertEquals(24,js.getList("data.id").size());
           assertTrue("Rhona Davidson",js.getList("data.employee_name").contains("Rhona Davidson"));


             // 1.WAY
        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(23);
        list.add(61);
        assertTrue(js.getList("data.employee_age").containsAll(list));

        // 2.WAY

        List<Integer> list2 = Arrays.asList(21,23,61);
        assertTrue(js.getList("data.employee_age").containsAll(list2));




    }
}
