package com.techproed.day10;

import com.techproed.freeWorks.JasonPlaceHolderTest;
import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.Matchers;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class PutRequest01 extends JsonPlaceHolderTestBase {
    /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde
https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde
   {
      "userId": 21,
      "title": "Wash the dishes",
      "completed": false
     }
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false,
 "id": 198
}
     */



    @Test

    public void test(){
        spec01.pathParam("first","todos");
        JsonPlaceHolderTestData expectedData= new JsonPlaceHolderTestData();
      JSONObject expectedRequest =expectedData.setUpPutData();

        Response response= given().
                contentType(ContentType.JSON).
                spec(spec01).
                auth().basic("admin","password123").
                body(expectedRequest.toString()).
                when().
                post("/{first}");
        //  response.prettyPrint();

        //Matchers class

        response.then().
                assertThat().statusCode(expectedRequest.getInt("statusCode"))
                .body("completed", equalTo(expectedRequest.getBoolean("completed")),
                        "title",equalTo(expectedRequest.getString("title")),
                        "userId",equalTo(expectedRequest.getInt("userId")));


        //JsonPath ile

        JsonPath json=response.jsonPath();

        Assert.assertEquals(expectedRequest.getInt("statusCode"),response.getStatusCode());
        Assert.assertEquals(expectedRequest.getInt("userId"),json.getInt("userId"));
        Assert.assertEquals(expectedRequest.getString("title"),json.getString("title"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"),json.getBoolean("completed"));

        //De Serialization

        HashMap<String,Object> actualDataMap=response.as(HashMap.class);

        Assert.assertEquals(expectedRequest.getString("title"),actualDataMap.get("title"));
        Assert.assertEquals(expectedRequest.getInt("userId"),actualDataMap.get("userId"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"),actualDataMap.get("completed"));


    }

}
