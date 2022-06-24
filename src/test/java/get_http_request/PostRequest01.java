package get_http_request;

import baseUrl.HerokuappBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
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

        spec05.pathParam("prm1","booking");

        HerokuappTestData newTestData= new HerokuappTestData();

        JSONObject expectedRequestData= newTestData.setupTestandRequestData();
        System.out.println("json expected data "+ expectedRequestData);


        Response response = RestAssured.given().contentType(ContentType.JSON)
                .auth()
                .basic("admin","password123").
                spec(spec05).
                body(expectedRequestData.toString())
                .post("/{prm1}");
                response.prettyPrint();


        JsonPath js= response.jsonPath();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedRequestData.getString("firstname"),js.getString("booking.firstname"));
        Assert.assertEquals(expectedRequestData.getString("lastname"),js.getString("booking.lastname"));
        Assert.assertEquals(expectedRequestData.getInt("totalprice"),js.getInt("booking.totalprice"));
        Assert.assertEquals(expectedRequestData.getBoolean("depositpaid"),js.getBoolean("booking.depositpaid"));
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkin")
                ,js.getString("booking.bookingdates.checkin"));

        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkout")// getJSONObject dememizin sebebi
             //   expected datayi olustururken (JSONObject bookingDates = new JSONObject()) tanimlamistik
                ,js.getString("booking.bookingdates.checkout"));


    }
}

