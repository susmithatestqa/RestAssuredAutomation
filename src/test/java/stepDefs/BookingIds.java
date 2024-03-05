package stepDefs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookingIds {
	Response response;
	
	@Test
	public void gerBookingIds() {
		response= RestAssured
		    .given().contentType(ContentType.JSON)
		    .baseUri("https://restful-booker.herokuapp.com/booking")
		.when().get()
		.then().assertThat().statusCode(200).extract().response();
		System.out.println(response.asPrettyString());
		Assert.assertTrue(response.getBody().asString().contains("bookingid"));
	}
	
}
