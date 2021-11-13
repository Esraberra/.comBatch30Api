package com.techproed.testBase;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.Before;

public class DummyRestApi {

  protected RequestSpecification spec03;

    @Before

    public void test(){
        spec03= new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1/").build();

    }




}
