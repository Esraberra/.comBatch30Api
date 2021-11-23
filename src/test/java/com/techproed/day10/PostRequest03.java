package com.techproed.day10;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest03 extends JsonPlaceHolderTestBase {

/*
https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     }
     "userId": 55,
     "title": "Tidy your room",
     "completed": false
   }
Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false,
     "id": …
    }
 */




    @Test
    public void test(){
        spec01.pathParam("first","todos");

        JsonPlaceHolderTestData requestData= new JsonPlaceHolderTestData();

   JSONObject expectedRequestData= requestData.JsonTestData();

   Response response=given().contentType(ContentType.JSON).spec(spec01).body(expectedRequestData.toString()).post("/{first}");
response.prettyPrint();

response.then().assertThat().statusCode(  expectedRequestData.getInt("statusCode")).body("completed",equalTo(expectedRequestData.getBoolean("completed")),
        "title",equalTo(expectedRequestData.getString("title")), "userId", equalTo(expectedRequestData.getInt("userId")));


//Jsonpath

        JsonPath json=response.jsonPath();
        Assert.assertEquals(expectedRequestData.getInt("userId"),json.getInt("userId"));
Assert.assertEquals(expectedRequestData.getString("title"),json.getString("title"));
Assert.assertEquals(expectedRequestData.getBoolean("completed"),json.getBoolean("completed"));

//deserialization

      HashMap<String, Object> actualData=response.as(HashMap.class);

        System.out.println(actualData);
Assert.assertEquals(expectedRequestData.getBoolean("completed"),actualData.get("completed"));
Assert.assertEquals(expectedRequestData.getString("title"),actualData.get("title"));
Assert.assertEquals(expectedRequestData.getInt("userId"),actualData.get("userId"));
Assert.assertEquals(expectedRequestData.getInt("statusCode"),actualData.get("statusCode"));
Assert.assertEquals(expectedRequestData.getInt("id"),actualData.get("id"));
    }

}
