package com.techproed.freeWorks;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DummyRestApiTest1 extends DummyTestBase {


    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request gonderdigimizde
donen response'un asagidaki gibi oldugunu test edin.
    Response Body
    {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
    }

     */

  @Test
  public void test(){

      spec03.pathParams("first","employee","second","3");

      Response response=given().accept("application/json").spec(spec03).
              when().get("/{first}/{second}");



      HashMap<String, Object> expectedData=new HashMap<>();

      expectedData.put("id",3);
      expectedData.put("employee_name","Ashton Cox");
      expectedData.put("employee_salary",86000);
      expectedData.put("employee_age",66);
      expectedData.put("profile_image","");

      HashMap<Object, Object> outerMap=new HashMap<>();

      outerMap.put("status","success");
      outerMap.put("data",expectedData);
      outerMap.put("message","Successfully! Record has been fetched.");

      response.prettyPrint();
      JsonPath jsonPath=response.jsonPath();

      Assert.assertEquals((int)expectedData.get("id"),jsonPath.getInt("data.id"));
      Assert.assertEquals(expectedData.get("employee_name"),jsonPath.getString("data.employee_name"));
Assert.assertEquals((int)expectedData.get("employee_salary"),jsonPath.getInt("data.employee_salary"));

Assert.assertEquals((int)expectedData.get("employee_age"),jsonPath.getInt("data.employee_age"));

Assert.assertEquals(expectedData.get("profile_image"),jsonPath.getString("data.profile_image"));


//for outermap validation !!

      Assert.assertEquals(outerMap.get("status"),jsonPath.getString("status"));
      Assert.assertEquals(outerMap.get("data"),jsonPath.getMap("data"));
      Assert.assertEquals(outerMap.get("message"),jsonPath.getString("message"));


  }


}
