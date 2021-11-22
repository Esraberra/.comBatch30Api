package com.techproed.freeWorks;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyRestApiTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DummyRestApiEng1 extends DummyTestBase {


    /*
    http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request gonderdigimizde
donen response'un asagidaki gibi oldugunu test edin.
 {
            "id": 7,
            "employee_name": "Herrod Chandler",
            "employee_salary": 137500,
            "employee_age": 59,
            "profile_image": ""
        },
        {
            "id": 8,
            "employee_name": "Rhona Davidson",
            "employee_salary": 327900,
            "employee_age": 55,
            "profile_image": ""
        },

        Content type should be json
        status code 200
        make sure Rhona Davidson earns more than Herrod Chandler


     */



    @Test public void test(){
        spec03.pathParam("first","employees");

        Response response=given().accept("application/json").spec(spec03).when().get("/{first}");
      /*
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getInt("data[6].employee_salary"));
        Assert.assertTrue(jsonPath.getInt("data[6].employee_salary")< jsonPath.getInt("data[7].employee_salary"));
*/
 //2.method
        DummyRestApiTestData testData=new
                DummyRestApiTestData();
       HashMap<String,Object> expectedData1=     testData.testDummyData();
        System.out.println(expectedData1);
        HashMap<String ,Object>expectedData2=testData.testDummyData1();
        System.out.println(expectedData2);

        HashMap<String ,Object> actualData=response.as(HashMap.class);
        System.out.println(actualData);

        Assert.assertTrue((Integer)(expectedData1.get("employee_salary"))< (Integer)  ( (Map) (  (List) actualData.get("data")).get(7)).get("employee_salary"));





    }
}
