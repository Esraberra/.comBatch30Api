package com.techproed.freeWorks;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class JasonPlaceHolderTest extends JsonPlaceHolderTestBase {



    @Test
    public void test(){
        spec01.pathParams("first","todos","second", 123);


//send the request and get the response
        //if you wanna send a Request, use when as action
//get the response
     Response response=   given().accept("application/json").spec(spec01).when().get("/{first}/{second}");
     response.prettyPrint();
    //    System.out.println(response.asString().contains("Not found"));
assertTrue(response.asString().contains("notfound"));
    }



}
