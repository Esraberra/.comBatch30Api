package com.techproed.testData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyRestApiTestData {

    /*
     {
 “id”:”11”
 "employee_name": "Jena Gaines",
"employee_salary": "90560",
"employee_age": "30",
"profile_image": "" }
} gibi olduğunu test edin.

5. Çalışan isminin "Airi Satou" olduğunu ,  çalışan sayısının 24 olduğunu,
Sondan 2. çalışanın maaşının 106450 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
11. Çalışan bilgilerinin
     */

    public HashMap<String, Object> setupData(){

        List<Integer> yaslar=new ArrayList<>();
        yaslar.add(40);
        yaslar.add(21);
        yaslar.add(19);

        HashMap<String,Object> onbirinciData= new HashMap<>();

        onbirinciData.put("id",11);
        onbirinciData.put("employee_name","Jena Gaines");
        onbirinciData.put("employee_salary",90560);
        onbirinciData.put("employee_age",30);
        onbirinciData.put("profile_image","");


        HashMap<String, Object> expectedData= new HashMap<>();
        expectedData.put("statusCode", 200);

        expectedData.put("besincicalisan", "Airi Satou");
        expectedData.put("calisanSayisi", 24);
        expectedData.put("sondanikinciCalisanMaas", 106450);
        expectedData.put("arananYaslar", yaslar);
        expectedData.put("onbirincicalisan",onbirinciData);

        return expectedData;


    }


    public HashMap<String,Integer> setUpTestData(){

        HashMap<String,Integer> expectedData =new HashMap<>();
        expectedData.put("statusCode",200);
        expectedData.put("enYüksekMaas",725000);
        expectedData.put("enKücükYas",19);
        expectedData.put("ikinciEnYüksekMaas",675000);

        return  expectedData;
    }

    /*
    "id": 7,
            "employee_name": "Herrod Chandler",
            "employee_salary": 137500,
            "employee_age": 59,
            "profile_image": ""


            "id": 8,
            "employee_name": "Rhona Davidson",
            "employee_salary": 327900,
            "employee_age": 55,
            "profile_image": ""

     */

    public HashMap<String,Object>testDummyData(){

        HashMap<String,Object> expectedData1=new HashMap<>();
        expectedData1.put("employee_name","Herrod Chandler");
        expectedData1.put("employee_salary",137500);




        return expectedData1;
    }

    public HashMap<String,Object>testDummyData1() {
        HashMap<String,Object> expectedData2=new HashMap<>();

        expectedData2.put("employee_name","Rhona Davidson");
        expectedData2.put("employee_salary",327900);

return expectedData2;
    }


    /*
    {
"name":"Esra Kücük",
"salary":"1000",
"age":"36"

}
     */
    public HashMap<String, String> setupRequestBody(){

        HashMap<String, String> requestBody=new HashMap<>();

requestBody.put("name","Esra Bahar");
requestBody.put("salary","58000");
requestBody.put("age","20");


return requestBody;

    }

    /*
    {
    "status": "success",
    "data": {
        "name": "Esra Kücük",
        "salary": "1000",
        "age": "36",
        "id": 9150
    },
    "message": "Successfully! Record has been added."
}
     */

public HashMap<String, Object> setUpExpectedData(){

        HashMap<String,Object> data=new HashMap<>();
        data.put("name","Esra Bahar");
        data.put("salary","1000");
        data.put("age","36");

HashMap<String, Object> expectedData= new HashMap<>();
expectedData.put("statusCode", 200);
expectedData.put("status", "success");
//expectedData.put("data",data);
expectedData.put("message","Successfully! Record has been added.");

return expectedData;

}


}
