package com.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class NonStaticImport {
	
	@Test
	public void simple_test_case()
	{
		RestAssured.
		given().
			baseUri("https://api.postman.com").
			header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
		when().
			get("/workspaces").
		then().
			statusCode(200);
	}

}
