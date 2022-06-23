package get_http_request;

import baseUrl.HerokuappBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.HerokuappTestData;

public class PostRequest01 extends HerokuappBaseUrl {
     /*
       https://restful-booker.herokuapp.com/booking
       { "firstname": "Ali",
                  "lastname": "Can",
                  "totalprice": 500,
                  "depositpaid": true,
                  "bookingdates": {
                      "checkin": "2022-03-01",
                      "checkout": "2022-03-11"
                   }
    }
    gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
    }
       "booking": {
           "firstname": "Ali",
           "lastname": "Can",
           "totalprice": 500,
           "depositpaid": true,
           "bookingdates": {
                               "checkin": "2022-03-01",
                                "checkout": "2022-03-11"
           }
       }
    }
    olduğunu test edin
        */

    @Test
    public void test(){

        spec05.pathParams("prm1","booking");

        HerokuappTestData newTestData= new HerokuappTestData();
        JSONObject expectedData= newTestData.setupTestandPostData();
        System.out.println("json expected data "+ expectedData);


        Response response = RestAssured.given().contentType(ContentType.JSON)
                .auth()
                .basic("admin","password123").
                spec(spec05).
                body(expectedData.toString())
                .post("/{prm1}");
                response.prettyPrint();


    }
}
