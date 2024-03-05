package stepDefs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.FileUtilitiy;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CreateBookingDetails {

	@Test
	public void BookingDetailsAPI() {
		try {
			String API_Req_Body = FileUtils.readFileToString(new File(FileUtilitiy.Post_Req_Body),"UTF-8");
		Response response = RestAssured.given().contentType(ContentType.JSON)
								.body(API_Req_Body)
								.baseUri("https://restful-booker.herokuapp.com/booking")
								.log().all()
								.when()
								.post()
								.then()
								.assertThat()
								.log().all()
								.statusCode(200).extract().response();
		System.out.println(response.asPrettyString());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
