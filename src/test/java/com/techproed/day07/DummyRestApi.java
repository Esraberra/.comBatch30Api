package com.techproed.day07;
import static io.restassured.RestAssured.given;
import com.techproed.testBase.DummyTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class DummyRestApi extends DummyTestBase {


    /*
    http://dummy.restapiexample.com/api/v1/employees
url ine bir istek gönderildiğinde
Dönen response un
 Status kodunun 200,
 1)10’dan büyük tüm id’leri ekrana yazdırın ve
10’dan büyük 14 id olduğunu,
 2)30’dan küçük tüm yaşları ekrana yazdırın ve
  bu yaşların içerisinde en büyük yaşın 23 olduğunu
 3)Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın ve
  bunların içerisinde “Charde Marshall” olduğunu test edin
     */



    @Test
    public void test(){

        spec03.pathParam("first","employees");

        Response response=given().accept("application/json").spec(spec03).when().get("/{first}");
//jsonpath sadece bod kismini jsonpath icine atar
        JsonPath jsonPath=response.jsonPath();
response.prettyPrint();
        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);

        Assert.assertEquals(200,response.getStatusCode());


        List<Integer> list1=jsonPath.getList("data.findAll{it.id>10}.id");

Assert.assertEquals(14,list1.size());

        List<Integer> list2=jsonPath.getList("data.findAll{it.employee_age<30}.employee_age");

    Collections.sort(list2);

    Assert.assertEquals(23,(int)list2.get(list2.size()-1));

        List<String> list3=jsonPath.getList("data.findAll{it.employee_salary>350000}.employee_name");

        Assert.assertTrue( list3.contains("Charde Marshall"));

        System.out.println(list3);

    }




}
