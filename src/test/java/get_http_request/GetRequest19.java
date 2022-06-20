package get_http_request;

import baseUrl.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class GetRequest19 extends DummyBaseUrl {

      /*
   http://dummy.restapiexample.com/api/v1/employees

   */

    @Test
    public void test(){

        spec02.pathParams("prm1","v1","prm2","employees");

        // http://dummy.restapiexample.com/api  ( Requestten once ki adres)

        Response response = RestAssured.given().spec(spec02).when().get("/{prm1}/{prm2}");
        // http://dummy.restapiexample.com/api/v1/employees  ( Requestten sonra ki adres)

        //   1) Status kodunun 200,

        Assert.assertEquals(200,response.statusCode());
       // response.then().statusCode(200);    // bu sekilkde de assert edilebilir

        //   2) 10’dan büyük tüm id’leri ekrana yazdırın ve 10’dan büyük 14 id olduğunu,
        // First, I need to form a List where stated all id's

        JsonPath js = response.jsonPath();

        List<Integer> idList= js.getList("data.id.findAll{it>10}");

        System.out.println("ID LIST " + idList);
        Assert.assertEquals(14,idList.size());


        //   3) 30’dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu

       List<Integer> agesList = js.getList("data.employee_age.findAll{it<30}");
      System.out.println("Ages List " + agesList);

      Collections.sort(agesList);
      Assert.assertEquals(23,(int) agesList.get(agesList.size()-1));
       // Assert.assertEquals((Integer) 23,agesList.get(agesList.size()-1));

        //   4) Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın
        List<Integer> nameList= js.getList("data.findAll{it.employee_salary>350000}.employee_name");

        System.out.println(nameList);

        // ve bunların içerisinde “Charde Marshall” olduğunu test edin
        Assert.assertTrue(nameList.contains("Charde Marshall"));






    }

}
