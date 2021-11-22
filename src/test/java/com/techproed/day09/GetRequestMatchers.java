package com.techproed.day09;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyRestApiTestData;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequestMatchers extends DummyTestBase {


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
response.then().assertThat().statusCode((Integer) expectedData.get("statusCode")).
        body("data.employee_name[4]",equalTo(expectedData.get("besincicalisan")),
                "data.id",hasSize((Integer) expectedData.get("calisanSayisi")),
                "data[-2].employee_salary",equalTo(expectedData.get("sondanikinciCalisanMaas")),
                "data.employee_age",hasItems(((List)expectedData.get("arananyaslar")).get(0),
                ((List<?>) expectedData.get("arananyaslar")).get(1),
                ((List<?>) expectedData.get("arananyaslar")).get(2)),
        "data[10].employee_name",equalTo(((Map)expectedData.get("onbirincicalisan")).get("employee_name")),
        "data[10].employee_salary",equalTo(((Map<?, ?>) expectedData.get("onbirincicalisan")).get("employee_salary")),
        "data[10].employee_age",equalTo(((Map<?, ?>) expectedData.get("onbirincicalisan")).get("employee_age")),
        "data[10].profile_image",equalTo(((Map<?, ?>) expectedData.get("onbirincicalisan")).get("profile_image")));





    }

}
