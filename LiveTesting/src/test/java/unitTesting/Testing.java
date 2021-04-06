package unitTesting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

@TestMethodOrder(OrderAnnotation.class)
public class Testing {

	String url = "http://bookingappv2-env.eba-jiuphjjt.eu-west-1.elasticbeanstalk.com";
	private static int discountId = -1;
	
	@Test
	@Order(1)
	public void testLoginUser(){
		
		String updUrl = url + "/loginuser";
		
		Response result = given().queryParam("name", "tester").queryParam("password", "tester").when().get(updUrl);
		
		String[] resultArr = result.asString().split(":");
		assertEquals("SUCCESS", resultArr[0]);
	}
	
	@Test
	@Order(3)
	public void testSearchDiscount(){
		
		String updUrl = url + "/getdiscount/";
		String code = "Test1";
		
		Response result = given().param("code", code).when().get(updUrl);
		
		String[] resultArr = result.asString().split(":");
		assertEquals("SUCCESS", resultArr[0]);
	}
	
	@Test
	@Order(2)
	public void testPostDiscount(){
		
		String updUrl = url + "/newdiscount";
		String code = "Test1";
		double prc = 20;
		ArrayList<String> lis = new ArrayList<>();
		lis.add("all");

		
		Response result = given().param("code", code).param("routeIds", lis).param("discountPercent", prc).when().post(updUrl);
		
		//System.out.println(result.asString());
		
		String[] resultArr = result.asString().split(": ");
		if(resultArr[0].equals("SUCCESS"))
			discountId = Integer.parseInt(resultArr[1]);
		//System.out.println(resultArr[1]);
		//System.out.println(discountId);
		assertEquals("SUCCESS", resultArr[0]);
	}
	
	@Test
	@Order(4)
	public void testDeleteDiscount(){
		
		String updUrl = url + "/deletediscount/" + discountId;
		
		Response result = given().when().post(updUrl);
		
		//System.out.println(result.asString());
		
		String[] resultArr = result.asString().split(": ");
		assertEquals("SUCCESS", resultArr[0]);
	}
}


