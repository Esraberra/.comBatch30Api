package com.techproed.freeWorks;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;

public class JsonPlaceHolderTestEng extends JsonPlaceHolderTestBase {
/*
Given https://jsonplaceholder.typicode.com/todos
When I send GET Request to the URL
Then 1)Statuscode is 200
2) Print all ids greater than 190 on the console
Assert that there are 10 ids greater than 190
3)Print all userIds less than 5 on the console
Assert that maximum userId less than 5 is 4
4)Print all titles whose ids are less than 5
Assert that "delectus out autem" is one of the titles whose id is less than 5


 */

@Test


    public void test(){

    JsonPlaceHolderTestData placeHolderTestData=new JsonPlaceHolderTestData();

    spec01.pathParam("first","todos");

    Response response= given().accept("application/json").spec(spec01).when().get("/{first}");

    response.then().assertThat().statusCode(200);


    JsonPath jsonPath=response.jsonPath();

  List<Integer> idList =jsonPath.getList("findAll{it.id>190}.id");
    System.out.println(idList);
    //Assert that there are 10 ids greater than 190
    Assert.assertEquals(10,idList.size());

List<Integer> userid= jsonPath.getList("findAll{it.userId<5}.userId");
    Collections.sort(userid);
Assert.assertEquals((Integer)4,userid.get(userid.size()-1));
    System.out.println(userid);

  //Print all titles whose ids are less than 5
  List<String> titles=  jsonPath.getList("findAll{it.id<5}.title");


Assert.assertTrue(titles.contains("delectus aut autem"));

    Assert.assertTrue(titles.stream().anyMatch(t->t.contains("delectus aut autem")));
    System.out.println(titles);


    }








}







