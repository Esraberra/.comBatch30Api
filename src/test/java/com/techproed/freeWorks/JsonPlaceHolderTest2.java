package com.techproed.freeWorks;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class JsonPlaceHolderTest2 extends JsonPlaceHolderTestBase {

    /*
		1) Create a class and name it as you wish :)
		2) When
		     I send a GET Request to https://jsonplaceholder.typicode.com/todos
		   Then
			 HTTP Status code should be "200"
			 And Content type should be in "JSON" format
			 And there should be 200 "title"
		//	 And "dignissimos quo nobis earum saepe" should be one of the "title"s
			// And 111, 121, and 131 should be among the "id"s
			// And 4th title is "et porro tempora"
			 And last title is "ipsam aperiam voluptates qui"
    */

@Test
    public void test() {
    spec01.pathParam("Parameter1", "todos");

    Response response = given().accept("application/json").spec(spec01).when().get("/{Parameter1}");
    //  response.prettyPrint();

    response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    JsonPath jsonPath = response.jsonPath();
    //  And there should be 200 "title"
    List<String> list = jsonPath.getList("title");

    Assert.assertEquals(200, list.size());

    //	 And "dignissimos quo nobis earum saepe" should be one of the "title"s

    Assert.assertTrue(jsonPath.getList("title").contains("dignissimos quo nobis earum saepe"));


    // And 111, 121, and 131 should be among the "id"s

    List<Integer> listTemp = new ArrayList<Integer>();
    listTemp.add(111);
    listTemp.add(121);
    listTemp.add(131);

    List<Integer> listem = jsonPath.getList("id");

     Assert.assertTrue(listem.containsAll(listTemp));

    //////////////////////////////
// And 4th title is "et porro tempora"

     Assert.assertEquals("et porro tempora", jsonPath.getString("title[3]"));

    // And last title is "ipsam aperiam voluptates qui"

     Assert.assertEquals("ipsam aperiam voluptates qui", jsonPath.getString("title[-1]"));


}

}
