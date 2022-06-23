package testData;

import org.junit.Test;
import java.util.HashMap;


public class JsonplaceholderTestData {

    @Test
    public HashMap<String,Object> setupTestData(){

         HashMap<String, Object> expectedData= new HashMap<>();

           expectedData.put("completed", false);
           expectedData.put("title", "quis ut nam facilis et officia qui");
           expectedData.put("userId", 1);
           expectedData.put("via", "1.1 vegur");
           expectedData.put("Server", "cloudflare");
           expectedData.put("statusCode", 200);
           expectedData.put("id", 2);
       return  expectedData;


    }


}
