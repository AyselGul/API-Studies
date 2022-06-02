package get_http_request;

import baseUrl.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class GetRequest08 extends DummyBaseUrl {

  // http://dummy.restapiexample.com/api/v1/employees url'inde bulunan






    @Test
    public void test(){
        spec02.pathParams("pm1","v1","pm2","employees");

        Response response = RestAssured.given().spec(spec02).get("/{pm1}/{pm2}");
       // response.prettyPrint();

        // To get all the worker's name, 1st JsonPath Obj. needs to be formed
        JsonPath js= response.jsonPath();

       // 1) Butun calisanlarin isimlerini consola yazdıralim
        System.out.println(js.getList("data.employee_name"));

        // 2) 3. calisan kisinin ismini konsola yazdıralim
        System.out.println(js.getString("data[2].employee_name"));

         // 3) Ilk 5 calisanin adini konsola yazdiralim

        for (int i = 0; i < 5; i++) {
            System.out.println(i+1+ ".worker : " + js.getString("data["+ i+ "].employee_name"));
        }

           // 4) En son calisanin adini konsola yazdiralim
           System.out.println(js.getString("data.employee_name[-1]"));


    }
}
