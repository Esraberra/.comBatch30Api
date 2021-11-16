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
        expectedData.put("statusCode", 200);
        expectedData.put("besincicalisan", "Airi Sataou");
        expectedData.put("calisanSayisi", 24);
        expectedData.put("sondanikinciCalisanMaas", 106450);
        expectedData.put("arananYaslar", yaslar);
        expectedData.put("onbirincicalisan",onbirinciData);

        return expectedData;

    }
}
