package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Authentication {
    // to reach te Database of GMI bnk, token needs to be used

    public static String generateToken(){
        String username="Batch44Api";
        String password="Batch44+";
        String endpoint="https://www.gmibank.com/api/authenticate";


        Map<String,Object> map = new HashMap<>();

        map.put(username,username);
        map.put(password,password);
        Response response = RestAssured.given().contentType(ContentType.JSON).body(map).post(endpoint);
        JsonPath token = response.jsonPath();
        return token.getString("id.token");
    }
}
