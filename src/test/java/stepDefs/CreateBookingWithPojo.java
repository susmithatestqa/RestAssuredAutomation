package stepDefs;

import org.testng.annotations.Test;

import com.testautomation.pojos.BookingDates;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testautomation.pojos.Booking;

public class CreateBookingWithPojo {
	String req;
	ObjectMapper obj = new ObjectMapper();
@Test
public void bookingWithPojoRequest() {
	BookingDates bd = new BookingDates("2023-08-09","2022-07-05");
	Booking bk = new Booking("sush","chin",2000,true,"needs",bd);	
	  try {
		req =obj.writerWithDefaultPrettyPrinter().writeValueAsString(bk);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 System.out.println(req);
	 

Response response = RestAssured.given().contentType(ContentType.JSON)
						.body(req)
						.baseUri("https://restful-booker.herokuapp.com/booking").log().all()
						.when()
						.post()
						.then().assertThat().statusCode(200)
						.extract().response();
}}
