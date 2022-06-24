package testData;

import org.json.JSONObject;
import org.junit.Test;
import java.util.HashMap;


public class JsonplaceholderTestData {

    @Test
    public HashMap<String, Object> setupTestData() {

        HashMap<String, Object> expectedData = new HashMap<>();

        expectedData.put("completed", false);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("userId", 1);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
        expectedData.put("statusCode", 200);
        expectedData.put("id", 2);
        return expectedData;


    }
    /*
       {
        "userId": 55,
            "title": "Tidy your room",
            "completed": false
    }


     */
public JSONObject setupPostData(){

    JSONObject postJsobj = new JSONObject();
    postJsobj.put("userId", 55);
    postJsobj.put("title","Tidy your room");
    postJsobj.put("completed", false);

    return postJsobj;
}

public JSONObject setupPutData(){

    JSONObject jsonObject = new JSONObject();

    jsonObject.put("userId", 21);
    jsonObject.put("title", "Wash the dishes");
    jsonObject.put("completed", false);
    return jsonObject;

}




    }


