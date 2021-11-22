package com.techproed.day09;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyRestApiTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest14 extends DummyTestBase {
/*
http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu, ->>
En yüksek maaşın 725000 olduğunu,body
En küçük yaşın 19 olduğunu,
İkinci en yüksek maaşın 675000
olduğunu test edin.
 */




    @Test
    public void test(){
        spec03.pathParam("first","employees");
        DummyRestApiTestData expectedDat=new DummyRestApiTestData();
        HashMap<String, Integer> expectedData = expectedDat.setUpTestData();
        Response response=given().accept("application/json").spec(spec03).when().get("/{first}");
        System.out.println(expectedData);
    //    response.prettyPrint();

      JsonPath jsonPath=response.jsonPath();

      Assert.assertEquals(java.util.Optional.ofNullable(expectedData.get("statusCode")), response.getStatusCode());

        List<Integer> maasListesi=jsonPath.getList("data.employee_salary");
        Collections.sort(maasListesi);
        System.out.println(maasListesi);
Assert.assertEquals(expectedData.get("enYüksekMaas"),maasListesi.get(maasListesi.size()-1));

List<Integer> ageList=jsonPath.getList("data.employee_age");
Collections.sort(ageList);
Assert.assertEquals(expectedData.get("enKücükYas"),ageList.get(0));
        Assert.assertEquals(expectedData.get("ikinciEnYüksekMaas"),maasListesi.get(maasListesi.size()-2));

        //2.method

        HashMap<String,Object> actualData=response.as(HashMap.class);
        System.out.println(actualData);

        //Status kodun 200 olduğunu, ->>
        Assert.assertEquals(expectedData.get("statusCode"), (Integer) response.getStatusCode());

       // En yüksek maasin 200 oldugunu 
        List<Integer> maasListesi1=new ArrayList<Integer>();

        int dataSize=( (List) actualData.get("data")).size();


        for (int i = 0; i <dataSize; i++) {

          maasListesi1.add ( (Integer)  ( (Map) (  (List)  actualData.get("data")).get(i) ).get("employee_salary"));

        }
Collections.sort(maasListesi1);
       Assert.assertEquals(expectedData.get("enYüksekMaas"),maasListesi1.get(maasListesi1.size()-1));


//ikinci en yüksek maas
        Assert.assertEquals(expectedData.get("ikinciEnYüksekMaas"),maasListesi1.get(maasListesi1.size()-2));


        //en kücük yasin 19 oldugunu
        List<Integer> ageList1=new ArrayList<>();

        for (int i = 0; i <dataSize ; i++) {
            ageList1.add( (Integer) ( (Map) ((List<?>) actualData.get("data")).get(i) ).get("employee_age")  );

        }
   Collections.sort(ageList1);

        Assert.assertEquals(expectedData.get("enKücükYas"),ageList1.get(0));
    }



}
