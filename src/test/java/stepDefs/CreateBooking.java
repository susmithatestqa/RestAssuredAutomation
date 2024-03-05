package stepDefs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class CreateBooking {

	@Test
	public void CreateBookingwithName() {
		JSONObject booking = new JSONObject();
		JSONObject bookingDates = new JSONObject();
		booking.put("firstname", "susmitha");
		booking.put("lastname", "test");
		booking.put("totalprice", 1000);
		booking.put("depositpaid", true);
		booking.put("bookingdates", bookingDates);
		booking.put("additionalneeds", "super");
		bookingDates.put("checkin", "2018-03-01");
		bookingDates.put("checkout", "2019-01-01");
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		System.out.println(booking.toJSONString());
		Response response = RestAssured
									.given()
									.contentType(ContentType.JSON)
									.body(booking.toString())
									.baseUri("https://restful-booker.herokuapp.com/booking").log().ifValidationFails()
									.when().post()
									.then().assertThat()
								    .statusCode(300)
									.extract().response();
		
		System.out.println(response.asPrettyString());
		
	}
                
}
