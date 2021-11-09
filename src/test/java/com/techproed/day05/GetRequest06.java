package com.techproed.day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest06 {
/*
https://jsonplaceholder.typicode.com/todos/123 url'ine
   accept type'i "application/json" olan GET request'i yolladigimda
   gelen response’un
  status kodunun 200
    ve content type'inin "application/json"
  ve Headers'daki "Server" in "cloudflare"
  ve response body'deki "userId"'nin 7
  ve "title" in "esse et quis iste est earum aut impedit"
  ve "completed" bolumunun false oldugunu test edin
 */



    @Test
    public void test(){

        String url="https://jsonplaceholder.typicode.com/todos/123";
        Response response=given().accept("application/json").when().get(url);
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        response.prettyPrint();
        String serverName=response.header("Server");

        Assert.assertEquals("cloudflare",serverName);

        System.out.println(serverName);
        response.then().assertThat().body("userId", equalTo(7), "title",
                equalTo("esse et quis iste est earum aut impedit"),"completed",equalTo(false));
    }
}
