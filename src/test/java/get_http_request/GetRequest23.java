package get_http_request;

import baseUrl.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyTestData;
import java.util.*;
import static org.hamcrest.Matchers.*;
public class GetRequest23 extends DummyBaseUrl {
            /*
   http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
   Status kodun 200 olduğunu,
   14. Çalışan isminin "Haley Kennedy" olduğunu,
   Çalışan sayısının 24 olduğunu,
   Sondan 3. çalışanın maaşının 675000 olduğunu
   40,21 ve 19 yaslarında çalışanlar olup olmadığını
   10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi
   {
           "id": 10,
           "employee_name": "Sonya Frost",
           "employee_salary": 103600,
           "employee_age": 23,
           "profile_image": ""
    }
     olduğunu test edin.
   */

    @Test
    public void test(){

        spec02.pathParams("prm1", "v1","prm2","employees");
        Response response = RestAssured.
                given().
                spec(spec02).
                get("/{prm1}/{prm2}");

        // response.prettyPrint();

        DummyTestData dtd= new DummyTestData();
        HashMap<String,Object> expectedData = dtd.setupTestData();

        System.out.println(expectedData);

        // DE-SERIALIZATION
        HashMap<String,Object> actualData = response.as(HashMap.class);

        System.out.println(actualData);
      Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
      Assert.assertEquals(expectedData.get("onDorduncuCalisan"), ((Map)((List)actualData.get("data")).get(13)).get("employee_name")  );
      Assert.assertEquals(expectedData.get("calisanSayisi"), ((List)actualData.get("data")).size());   //24

        int dataSize=((List<?>) actualData.get("data")).size();

      Assert.assertEquals(expectedData.get("sondanUcuncuCalisanMaas"),
              ((Map)((List)actualData.get("data")).get(dataSize-3)).get("employee_salary"));


      List<Integer> actualAgesList= new ArrayList<>(); // Istenen yaslari bulmak icin oncelik olarak responce'tan gelen tum employee_age bir listeye
        // atariz

        for (int i = 0; i < dataSize; i++) {
           actualAgesList.add ((Integer) ((Map)((List<?>) actualData.get("data")).get(i)).get("employee_age"));
            // tum empleyye_age leri fori ile actualData'dan alip listeye ekledik
            }


        Assert.assertTrue(actualAgesList.containsAll((Collection<?>) expectedData.get("arananYaslar")));

        Assert.assertEquals(((Map)expectedData.get("onuncuCalisan")).get("id"),
                ((Map)((List)actualData.get("data")).get(10)).get("id"));

        Assert.assertEquals(((Map)expectedData.get("onuncuCalisan")).get("employee_name"),
                ((Map)((List)actualData.get("data")).get(10)).get("employee_name"));


        Assert.assertEquals(((Map)expectedData.get("onuncuCalisan")).get("employee_salary"),
                ((Map)((List)actualData.get("data")).get(10)).get("employee_salary"));


        Assert.assertEquals(((Map)expectedData.get("onuncuCalisan")).get("employee_age"),
                ((Map)((List)actualData.get("data")).get(10)).get("employee_age"));


        Assert.assertEquals(((Map)expectedData.get("onuncuCalisan")).get("profile_image"),
                ((Map)((List)actualData.get("data")).get(10)).get("profile_image"));



        response.then().statusCode((Integer) expectedData.get("statusCode"))
                .body("data[14].employee_name",equalTo(expectedData.get("onDorduncuCalisan")),
                        "data.id",hasSize((Matcher<? super Integer>) expectedData.get("calisanSayisi")),
                  "data[-3].employee_salary", equalTo(expectedData.get("sondanUcuncuCalisanMaas")),
                 "data.employee_age",hasItems(  ((List)expectedData.get("arananYaslar")).get(0),
                 ((List)expectedData.get("arananYaslar")).get(1),
                ((List)expectedData.get("arananYaslar")).get(2)),
        "data[9].employee_name",equalTo(((Map) expectedData.get("onuncuCalisan")).get("employee_name")),
        "data[9].employee_salary",equalTo(((Map) expectedData.get("onuncuCalisan")).get("employee_salary")),
        "data[9].profile_image",equalTo(((Map) expectedData.get("onuncuCalisan")).get("profile_image")),
        "data[9].id",equalTo(((Map) expectedData.get("onuncuCalisan")).get("id")),
        "data[9].employee_age",equalTo(((Map) expectedData.get("onuncuCalisan")).get("employee_age")));





    }


    }


