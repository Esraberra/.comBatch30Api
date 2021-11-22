package com.techproed.day08;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyRestApiTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class DummyRestApi extends DummyTestBase {


    /*
   http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu,
5. Çalışan isminin "Airi Satou" olduğunu ,  çalışan sayısının 24 olduğunu,
Sondan 2. çalışanın maaşının 106450 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
11. Çalışan bilgilerinin
  {
 “id”:”11”
 "employee_name": "Jena Gaines",
"employee_salary": "90560",
"employee_age": "30",
"profile_image": "" }
} gibi olduğunu test edin.

     */

    @Test
    public void test(){
spec03.pathParam("first","employees");
        DummyRestApiTestData expectedObje= new DummyRestApiTestData();
      HashMap<String,Object> expectedData= expectedObje.setupData();
        System.out.println(expectedData);

Response response=given().
        accept("application/json").
        spec(spec03).
        when().
        get("/{first}");


//response.prettyPrint();

//deserialization islemi:
        HashMap<String,Object> actualData=response.as(HashMap.class);

        System.out.println(actualData);


        Assert.assertEquals(expectedData.get("statusCode"),response.getStatusCode());
        Assert.assertEquals(expectedData.get("besincicalisan"),
                ((Map)((List)actualData.get("data")).get(4)).get("employee_name"));

        Assert.assertEquals(expectedData.get("calisanSayisi"),((List<?>) actualData.get("data")).size());
//önce actual datadan bize dönen listin size ini almaliyiz.
        int dataSize=((List<?>) actualData.get("data")).size();
        Assert.assertEquals(expectedData.get("sondanikinciCalisanMaas"),((Map)((List<?>) actualData.get("data")).get(dataSize-2)).get("employee_salary"));


        List<Integer> listeEmployeAge= new ArrayList<Integer>();

        for (int i = 0; i < dataSize; i++) {

            listeEmployeAge.add( (Integer)    ((Map)((List) actualData.get("data")).get(i)).get("employee_age") );

        }

 Assert.assertTrue(listeEmployeAge.containsAll((List) expectedData.get("arananYaslar")));
/*
        11. Çalışan bilgilerinin
        {
 “id”:”11”
            "employee_name": "Jena Gaines",
                "employee_salary": "90560",
                "employee_age": "30",
                "profile_image": "" }
    } gibi olduğunu test edin.


     */


        Assert.assertEquals(( (Map) expectedData.get("onbirincicalisan")).get("employee_name"),
                ( (Map) ((List<?>) actualData.get("data")).get(10)).get("employee_name"));

        Assert.assertEquals(((Map<?, ?>) expectedData.get("onbirincicalisan")).get("employee_salary"),
                ((Map) ((List<?>) expectedData.get("data")).get(10)).get("employee_salary"));
        Assert.assertEquals(((Map<?, ?>) expectedData.get("onbirincicalisan")).get("employee_age"),
                ((Map) ((List<?>) expectedData.get("data")).get(10)).get("employee_age"));
        Assert.assertEquals(((Map<?, ?>) expectedData.get("onbirincicalisan")).get("profile_image"),
                ((Map) ((List<?>) expectedData.get("data")).get(10)).get("profile_image"));
    }


}
