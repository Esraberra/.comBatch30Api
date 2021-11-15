package com.techproed.day07;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonPlaceHolder extends JsonPlaceHolderTestBase {



   @Test

   public void test(){

      spec01.pathParams("first","todos","second","2");

      HashMap<String, Object> expectedData=new HashMap<String, Object >();

expectedData.put("statusCode",200);
expectedData.put("Via","1.1 vegur");
expectedData.put("Server", "cloudflare");
expectedData.put("userId",1);
expectedData.put("title","quis ut nam facilis et officia qui");
expectedData.put("completed","false");

      Response response=given().accept("application/json").
              spec(spec01).when().
              get("/{first}/{second}");

      JsonPath jsonPath=response.jsonPath();
      response.then().assertThat().statusCode(200);
      response.prettyPrint();
     //1.yöntem
        response.then().assertThat().statusCode((Integer)expectedData.get("statusCode")).
               headers("via", equalTo(expectedData.get("Via")),
                       "Server",equalTo(expectedData.get("Server"))).
               body("userId",equalTo(expectedData.get("userId")),
                       "title",equalTo(expectedData.get("title")),
                       "completed",equalTo(expectedData.get("completed")));
//2. yöntem

       Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
       Assert.assertEquals(expectedData.get("via"),response.getHeader("via"));
       Assert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));
       Assert.assertEquals(expectedData.get("userId"),jsonPath.getInt("userId"));
       Assert.assertEquals(expectedData.get("title"),jsonPath.getString("title"));
       Assert.assertEquals(expectedData.get("completed"),jsonPath.getBoolean("completed"));
       //3. yöntem  deserialization
       //   --object mapper
       //   --pojo class ile birlite map



   }
}


/*
Assert.assertEquals("false",jsonPath.getString("completed"));
      Assert.assertEquals("quis ut nam facilis et officia qui",jsonPath.getString("title"));
      Assert.assertEquals(1,jsonPath.getInt("userId"));
     Assert.assertEquals("1.1 vegur",response.getHeader("Via"));
     Assert.assertEquals("cloudflare",response.getHeader("Server"));
      System.out.println(response.getHeaders());

 */