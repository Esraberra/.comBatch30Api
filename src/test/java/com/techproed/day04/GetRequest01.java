package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
/*
https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
HTTP status kodunun 200
Content Type’in Json
Ve Status Line’in HTTP/1.1 200 OK Oldugunu test edin
 */
 //1-api testi yaparken ilk olarak url(endpoint)  belirlenmeli
 //2-beklenen sonuc(expected result) olusturulur
 // bu case debenden body dogrulamasi istenmedigi icin simdilik beklenen sonuc
    //3-request gönder
    //4-actual result olustur
    //dogrulama yap(assertion)
@Test
public void test01(){
    String url="https://restful-booker.herokuapp.com/booking/3";

//Given:istenen endpoint sorgusundan önce yapılacak gereklilikleri ifade eder
    //request yaptik simdi Response klasindan olusturdgumiz nesneye depoöadik gelen response
    Response response= given().accept("application/json").when().get(url);

response.prettyPrint();

//response body ile ilgili islem yapmayacagimiz icin simdi olusturmyacagiz.

    System.out.println("status code"+response.getStatusCode());
    System.out.println("content type"+response.getContentType());
    System.out.println("status line"+response.getStatusLine());
/*
    Assert.assertEquals(200,response.getStatusCode());
    //status code int deger döndürür
    Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
    Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
    System.out.println(response.getHeaders());

 */
    //expected datayi heniz body gerekmedigi icin olusturmuyoruz
    //request gönder: given ile

    response.then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            statusLine("HTTP/1.1 200 OK");


}





}
