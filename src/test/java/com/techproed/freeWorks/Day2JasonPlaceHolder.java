package com.techproed.freeWorks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Day2JasonPlaceHolder {

    /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Response'in
        status code'unun 200,
        ve content type'inin Aplication.JSON,
        		ve response body'sinde bulunan userId'nin 5,
        		ve response body'sinde bulunan title'in "optio dolor molestias sit"
        			oldugunu test edin.
         */

    @Test
    public void test() {
        String url="https://jsonplaceholder.typicode.com/posts/44";

        //for getRequest;
   Response response=given().accept("application/json").when().get(url);
   response.prettyPrint();

   response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

   response.then().assertThat().body("userId",equalTo(5),"title",equalTo("optio dolor molestias sit"));

    }




}
