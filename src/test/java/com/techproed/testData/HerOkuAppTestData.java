package com.techproed.testData;

import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class HerOkuAppTestData {






    public HashMap<String, Object> test(){


        HashMap<String,Object> bookingDates=new HashMap<>();
        bookingDates.put("checkin", "2016-09-09");
        bookingDates.put("checkout","2017-09-21");

        HashMap<String, Object> expectedData=new HashMap<String, Object>();
        expectedData.put("firstname","Eric");

        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",555);
        expectedData.put("depositpaid",false);
        expectedData.put("bookingdates",bookingDates);

        return expectedData;
    }
    /*
    "firstname": "Selim",
               "lastname": "Ak",
               "totalprice": 11111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-09",
                   "checkout": "2020-09-21"
     */


    public JSONObject setupTestAndRequestData(){
        JSONObject bookingdates= new JSONObject();

        bookingdates.put("checkin","2020-09-09");
        bookingdates.put("checkout","2020-09-21");
        JSONObject expectedRequest =new JSONObject();
        expectedRequest.put("firstname","Esra");
        expectedRequest.put("lastname","Seymen");
        expectedRequest.put("totalprice",58000);
        expectedRequest.put("depositpaid",true);
        expectedRequest.put("bookingdates",bookingdates);

        return expectedRequest;
    }

}
