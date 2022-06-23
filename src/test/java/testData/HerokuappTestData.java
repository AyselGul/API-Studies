package testData;

import java.util.HashMap;
import java.util.Map;

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

        }