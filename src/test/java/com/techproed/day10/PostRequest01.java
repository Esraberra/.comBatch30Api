package com.techproed.day10;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyRestApiTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostRequest01 extends DummyTestBase {
/*
http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
{
    "name":"Ahmet Aksoy",
           "salary":"1000",
           "age":"18",
           "profile_image": ""
}
gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
{
   "status": "success",
           "data": {
        “id”:…
   },
   "message": "Successfully! Record has been added."
}
olduğunu test edin
 */
@Test
    public void test(){

spec03.pathParam("parametre1","create");

    DummyRestApiTestData expectedObje=new DummyRestApiTestData();

    HashMap<String, String> requestBodyMap=  expectedObje.setupRequestBody();

    HashMap<String, Object> expectedDataMap=expectedObje.setUpExpectedData();

    Response response=given().accept("application/json").spec(spec03).auth().basic("admin","password123").body(requestBodyMap).when().post("/{parametre1}");
    response.prettyPrint();
    //Deserialization

    HashMap<String,Object> actualDataMap=response.as(HashMap.class);
    Assert.assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());
    Assert.assertEquals(expectedDataMap.get("status"),actualDataMap.get("status"));
    Assert.assertEquals(expectedDataMap.get("message"),actualDataMap.get("message"));





}



}
