package com.rest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RequestSpecificationExample  {
	
	RequestSpecification requestSpecification; // class instance variable
	
	@BeforeClass
	public void beforeClass()
	{
		requestSpecification = with(). // Assigning the value to the variable
				baseUri("https://api.postman.com").
				header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
				log().all();
		
	}
	
	@Test
	public void validate_status_code()
	{
		Response response = requestSpecification.
		get("/workspaces").
		then().
		log().all().
		extract().
		response();
		
		assertThat(response.statusCode(), is(equalTo(200)));

	}
	
	@Test
	public void validate_response_body()
	{		
		Response response = requestSpecification.
		get("/workspaces").
		then().
		log().all().
		extract().
		response();
		
		assertThat(response.path("workspaces[0].name").toString(), equalTo("My Workspace"));
	}

}
