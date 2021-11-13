package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking/5 url’ine bir request yolladigimda
        HTTP Status Code’unun 200
        ve response content type’inin “application/JSON” oldugunu
            ve response body’sinin asagidaki gibi oldugunu test edin
                {"firstname": Sally,
                "lastname": "Smith",
                "totalprice": 789,
                "depositpaid": false,
                "bookingdates": {     "checkin": "2017-12-11",
                                                    "checkout":"2020-02-20" }
            }
     */
    protected RequestSpecification spec02;
  @Before
  public void test(){
      spec02=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
  }


}
