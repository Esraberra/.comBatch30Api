package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {

/*
   https://restful-booker.herokuapp.com/booking url'ine
   accept type'i "application/json" olan GET request'i yolladigimda
   gelen response'un
   status kodunun 200
   content type'inin "application/json" oldugunu test edin

    */

    @Test
    public void test() {
        String url="https://restful-booker.herokuapp.com/booking";
//expected datayi heniz body gerekmedigi icin olusturmuyoruz
        //request gönder: given ile                    when ile kullanici action u belirtitiz
        Response response=given().accept("application/json").when().get(url);

        response.prettyPrint();

response.then().assertThat().contentType(ContentType.JSON).statusCode(200);

    }



}
