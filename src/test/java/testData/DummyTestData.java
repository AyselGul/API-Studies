package testData;

import baseUrl.DummyBaseUrl;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DummyTestData  {

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
        },
     olduğunu test edin.
   */


        public HashMap<String,Object> setupTestData(){

            List<Integer> ageList= Arrays.asList(40,21,19);

            HashMap<String,Object> onuncuCalisan = new HashMap<>();
            onuncuCalisan.put("id",10);
            onuncuCalisan.put("employee_name","Sonya Frost");
            onuncuCalisan.put("employee_salary", 103600);
            onuncuCalisan.put("employee_age", 23);
            onuncuCalisan.put("profile_image","");

            HashMap<String,Object> expectedData = new HashMap<>();
            expectedData.put("statusCode",200);
            expectedData.put("onDorduncuCalisan","Haley Kennedy");
            expectedData.put("calisanSayisi",24);
            expectedData.put("sondanUcuncuCalisanMaas",675000);
            expectedData.put("arananYaslar",ageList);
            expectedData.put("onuncuCalisan",onuncuCalisan);
            return expectedData;

            }


    public JSONObject setupDelete(){

        JSONObject jsobj= new JSONObject();

        jsobj.put("status", "success");
        jsobj.put("data", "6");
        jsobj.put("message", "Successfully! Record has been deleted");

        return jsobj;

    }
        }



