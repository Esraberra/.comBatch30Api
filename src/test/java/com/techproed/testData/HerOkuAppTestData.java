package com.techproed.testData;

import io.restassured.response.Response;

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

}
