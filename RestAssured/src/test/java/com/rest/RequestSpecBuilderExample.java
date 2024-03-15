package com.rest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RequestSpecBuilderExample {
	
	RequestSpecification requestSpecification;  //Class instance variable
	
	@BeforeClass
	public void beforeClass()
	{
		RequestSpecBuilder requestSpecbuilder = new RequestSpecBuilder();
		requestSpecbuilder.setBaseUri("https://api.postman.com");
		requestSpecbuilder.addHeader("x-api-key", "PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179");
		requestSpecbuilder.log(LogDetail.ALL);
		
		requestSpecification = requestSpecbuilder.build();
		
	}
	
	@Test
	public void validate_Status_code()
	{
		 Response response = given(requestSpecification).
				 header("header","dumyHeader").
//		 		spec(requestSpecification).
				 get("/workspaces").
		 then().
			 	log().all().
			 	assertThat().
			 	statusCode(200).
			 	extract().
			 	response();
		
		 
		 assertThat(response.statusCode(), is(equalTo(200)));
	}
	
	@Test
	public void validate_response_body()
	{
		Response response = given(requestSpecification).
//		 	spec(requestSpecification).
		 	get("/workspaces").
		 then().
		 	log().all().
		 	assertThat().
		 	statusCode(200).
		 	extract().
		 	response();
		
		assertThat(response.path("workspaces[0].name"), is(equalTo("My Workspace")));
		 	
	}

}
