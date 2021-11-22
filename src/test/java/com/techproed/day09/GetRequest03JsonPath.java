package com.techproed.day09;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyRestApiTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest03JsonPath extends DummyTestBase {

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
    public void test() {
        spec03.pathParam("first", "employees");
        DummyRestApiTestData expectedObje = new DummyRestApiTestData();
        HashMap<String, Object> expectedData = expectedObje.setupData();
        System.out.println(expectedData);

        Response response = given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{first}");


        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(expectedData.get("statusCode"), response.getStatusCode());

        Assert.assertEquals("Airi Satou", jsonPath.getString("data.employee_name[4]"));
        Assert.assertEquals(expectedData.get("besinciCalisan"), jsonPath.getString("data.employee_name[4]"));

        Assert.assertEquals(expectedData.get("calisanSayisi"), jsonPath.getList("data.id").size());
        Assert.assertEquals(expectedData.get("sondanikinciCalisanMaas"), jsonPath.getInt("data[-2].employee_salary"));

Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll((Collection<?>) expectedData.get("aranaYaslar")));
Assert.assertEquals(( (Map) expectedData.get("onbirincicalisan")).get("id"),
        jsonPath.getInt("data[10].id"));


Assert.assertEquals(((Map<?, ?>) expectedData.get("onbirincicalisan")).get("employee_salary"),jsonPath.getInt("data[10].employee_salary"));

Assert.assertEquals(((Map<?, ?>) expectedData.get("onbirincicalisan")).get("employee_age"),
        jsonPath.getInt("data.[10.employee_age]"));

        Assert.assertEquals(((Map<?, ?>) expectedData.get("onbirincicalisan")).get("profile_image"),
                jsonPath.getString("data.[10.profile_image]"));
    }
}