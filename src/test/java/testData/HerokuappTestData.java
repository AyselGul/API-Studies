package testData;
import org.json.JSONObject;
import java.util.HashMap;

public class HerokuappTestData {

    public HashMap<String, Object> setupTestData() {

        HashMap<String, Object> bookingDates = new HashMap<>();

        bookingDates.put("checkin","2013-02-23");
        bookingDates.put("checkout","2014-10-23");

        HashMap<String,Object> expectedData= new HashMap<>();
        expectedData.put("firstname","Sally");
        expectedData.put("lastname","Brown");
        expectedData.put("totalPrice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("additionalneeds","Breakfast");
        expectedData.put("bookingdates",bookingDates);

      return expectedData;
    }

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
     */
          public JSONObject setupTestandRequestData(){

              JSONObject bookingDates = new JSONObject();  // MAP teki gibi HashMap<String,Object> type islemi yok direk obj.olustururuz
              bookingDates.put("checkin","2022-03-01");         // degerleri K-V seklinde alir
              bookingDates.put("checkout","2022-03-11");


              JSONObject expectedRequestBody = new JSONObject();
              expectedRequestBody.put("firstname","Ali");
              expectedRequestBody.put("lastname", "Can");
              expectedRequestBody.put("totalprice", 500);
              expectedRequestBody.put("depositpaid", true);
              expectedRequestBody.put("bookingdates", bookingDates);


              return expectedRequestBody;

          }
        }