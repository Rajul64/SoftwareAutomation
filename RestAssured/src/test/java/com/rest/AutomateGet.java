package com.rest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.config.LogConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutomateGet {
	
	@Test
	public void validate_Get_status_code()
	{
		given().
			baseUri("https://api.postman.com").
			header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
		when().
			get("/workspaces").
		then().
			log().all().
			assertThat().
			statusCode(200);
			
//		 negative failed scenario
			/*assertThat().
			statusCode(201).
			log().all();*/
	}
	
	@Test
	public void validate_response_body()
	{
		given().
			baseUri("https://api.postman.com").
			header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
		when().
			get("/workspaces").
		then().log().all().
			assertThat().
			statusCode(200).
			body("workspaces.name", hasItems("My Workspace1","MyWorkspace"),
					"workspaces.type", hasItems("personal","personal"),
					"workspaces[0].name", equalTo("My Workspace1"),
					"workspaces[0].name", is(equalTo("My Workspace1")), //more readable format
					"workspaces.size()", equalTo(2),
					"workspaces.name", hasItems("My Workspace1"));
			
	}
	
	@Test
	public void extract_response()
	{
  Response res = given(). //response object creation
			baseUri("https://api.postman.com").
			header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
		when().
			get("/workspaces").
		then().
			log().all().
			assertThat().
			statusCode(200).
			extract().
			response(); // the entire response object including body, cookies and headers
		System.out.println("Response = "+res.asString());
	}
	
	@Test
	public void extract_single_value_from_the_response()
	{
		String name = given(). //response object creation
				baseUri("https://api.postman.com").
				header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
			when().
				get("/workspaces").
			then().
				log().all().
				assertThat().
				statusCode(200).
				extract().
				response().path("workspaces[0].name");   // the entire response object including body, cookies and headers
			System.out.println("Workspaces name = "+name);
//			System.out.println("Workspaces name = "+JsonPath.from(res).get("workspaces[0].name"));
//			JsonPath jsonpath = new JsonPath(res.asString());
//			System.out.println("Workspaces name = "+jsonpath.getString("workspaces[0].name"));
//			System.out.println("Workspaces name = "+res.path("workspaces[0].name")); // Jpath expression
		}
	
	@Test
	public void hamcrest_assert_on_extracted_response()
	{
		String name = given(). //response object creation
				baseUri("https://api.postman.com").
				header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
			when().
				get("/workspaces").
			then().
				log().all().
				assertThat().
				statusCode(200).
				extract().
				response().path("workspaces[0].name");   // the entire response object including body, cookies and headers
			System.out.println("Workspaces name = "+name);
			
			assert(name.equals("My Workspace1")); // hemcrest Assertions
//			Assert.assertEquals(name, "My Workspace1"); // TestNG Assertions
//			System.out.println("Workspaces name = "+JsonPath.from(res).get("workspaces[0].name"));
//			JsonPath jsonpath = new JsonPath(res.asString());
//			System.out.println("Workspaces name = "+jsonpath.getString("workspaces[0].name"));
//			System.out.println("Workspaces name = "+res.path("workspaces[0].name")); // Jpath expression
	}
	
	@Test
	public void validate_response_body_hemcrest_learning()
	{
			given(). 
				baseUri("https://api.postman.com").
				header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
			when().
				get("/workspaces").
			then().
				log().all().
				assertThat().
				statusCode(200).
				body("workspaces.name", contains("My Workspace","MyWorkspace"), // contains method strict to all elements
						"workspaces.name", containsInAnyOrder("MyWorkspace","My Workspace"),
//						"workspaces.name", empty()); 
//						"workspaces.name", is(not(empty())) // generic check
						"workspaces.name", is(not(emptyArray())), //specific for collection
						"workspaces.name", hasSize(2),  // to check the size of an array
						"workspaces.name", everyItem(startsWith("My")), 
						"workspaces[0]", hasKey("id"), // to check the map key
						"workspaces[0]", hasValue("My Workspace"), // to check the map value
						"workspaces[0]", hasEntry("id","c262c133-e727-41e3-83b2-ac5090636991"), //to check if map having the complete entry
//						"workspaces[0]", equalTo(Collections.EMPTY_MAP)
						"workspaces[0]", not(equalTo(Collections.EMPTY_MAP))
//						"workspaces[0].name", allOf(startsWith("My")), containsString("Workspace"), // Matches if all matchers matches
//						"workspaces[0].name", anyOf(startsWith("My")), containsString("Workspace")
					);
				/*extract().
				response().path("workspaces[0].name");   // the entire response object including body, cookies and headers
			System.out.println("Workspaces name = "+name);*/
	}
	
	@Test
	public void request_response_logging()
	{
		given(). 
			baseUri("https://api.postman.com").
			header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
			config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
//			log().all().  // It will print the request info
//			log().ifValidationFails().  // It will print the request info only if the validation fails
		when().
			get("/workspaces").
		then().
//			log().ifError(). // It will Print the response info only if there is an error in the request
//			log().all().	//  It will print the response info
//			log().ifValidationFails(). // It will print the response info only if the validation fails
			assertThat().
			statusCode(201);
	}
	
//	============================= headers ============================================== //
	
	@Test
	public void log_blacklist_header()
	{
		Set<String> headers = new HashSet<String>();
		headers.add("x-api-key");
		headers.add("Accept");
		
	given().
			baseUri("https://api.postman.com").
			header("x-api-key","PMAK-620a1a443e49491d8fc0ea1c-d5d15fe54c832ed449de6be157f5857179").
//			config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
//			config(config.logConfig(LogConfig.logConfig().blacklistHeader("x-api-key"))).   // For blacklisting a header
			config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers))).   // For blacklisting multiple headers
			log().all().  // It will print the request info
//			log().ifValidationFails().  // It will print the request info only if the validation fails
	when().
			get("/workspaces").
	then().
//			log().ifError(). // It will Print the response info only if there is an error in the request
//			log().all().	//  It will print the response info
//			log().ifValidationFails(). // It will print the response info only if the validation fails
			assertThat().
			statusCode(200);
	}
	
	@Test
	public void multiple_headers()
	{
		Header header = new Header("header","value1");
		Header headerMatcher = new Header("x-mock-match-request-headers","header");
		given(). 
			baseUri("https://8c130e85-619a-4e78-8ccd-04d0541bc49b.mock.pstmn.io").
			header(header).
			header(headerMatcher).	
		when().
			get("/get").
		then().
			log().all().
			assertThat().
			statusCode(200);
	}
	
	@Test
	public void multiple_header_request_using_headers_Method()
	{
		Header header = new Header("header","value1");
		Header headerMatcher = new Header("x-mock-match-request-headers","header");
		
		Headers headers = new Headers(header, headerMatcher);
		
		given(). 
			baseUri("https://8c130e85-619a-4e78-8ccd-04d0541bc49b.mock.pstmn.io").
			headers(headers).
		when().
			get("/get").
		then().
			log().all().
			assertThat().
			statusCode(200);
	}
	
	@Test
	public void multiple_headers_in_request_using_map() {
		HashMap<String, String> headersmap = new HashMap<>();
		headersmap.put("header", "value1");
		headersmap.put("x-mock-match-request-headers", "header");
		
		given(). 
			baseUri("https://8c130e85-619a-4e78-8ccd-04d0541bc49b.mock.pstmn.io").
			headers(headersmap).	
		when().
			get("/get").
		then().
			log().all().
			assertThat().
			statusCode(200);
	}
	
	@Test
	public void multi_value_header_in_the_request()
	{
		Header header1 = new Header("multiValueHeader","value1");	//headers objects
		Header header2 = new Header("multiValueHeader","value2");	//headers objects
		
		Headers headers = new Headers(header1, header2);  
		
		given(). 
			baseUri("https://8c130e85-619a-4e78-8ccd-04d0541bc49b.mock.pstmn.io").
			headers(headers).
//			header("multiValueHeader", "value1", "value2").
			log().headers().
		when().
			get("/get").
		then().
			log().all().
			assertThat().
			statusCode(200);
	}
	
	@Test
	public void assert_on_response_header()
	{
		HashMap<String, String> headersMap = new HashMap<>();
		headersMap.put("header", "value2");
		headersMap.put("x-mock-match-request-headers", "header");
		
		given(). 
			baseUri("https://8c130e85-619a-4e78-8ccd-04d0541bc49b.mock.pstmn.io").
			headers(headersMap).
			log().headers().
		when().
			get("/get").
		then().
			log().all().
			assertThat().
			statusCode(200).
			headers("responseHeader","resValue2","X-RateLimit-Limit","120");
//		or
//			header("responseHeader", "resValue2").
//			header("X-RateLimit-Limit","120");
	}
	
	@Test
	public void extract_response_header()
	{
		HashMap<String, String> headersMap = new HashMap<>();
		headersMap.put("header", "value2");
		headersMap.put("x-mock-match-request-headers", "header");
		
		Headers extractedheaders = given(). //Headers object creation // extractedheaders ref variable will store all the headers available
			baseUri("https://8c130e85-619a-4e78-8ccd-04d0541bc49b.mock.pstmn.io").
			headers(headersMap).
			log().headers().
		when().
			get("/get").
		then().
			log().all().
			assertThat().
			statusCode(200).
			extract().
			headers();
		
		for(Header header:extractedheaders) // for each header in the extractedheaders
		{
			System.out.println("Heade Name = "+header.getName());
			System.out.println("Heade Value = "+header.getValue());
		}
//		System.out.println("Header Name = "+extractedheaders.get("responseHeader").getName());
//		System.out.println("Header Value = "+extractedheaders.get("responseHeader").getValue());
// or	System.out.println("Header Value = "+extractedheaders.getValue("responseHeader"));
	}
	
	@Test
	public void extract_multi_value_response_header()
	{
		HashMap<String, String> headersMap = new HashMap<>();
		headersMap.put("header", "value1");
		headersMap.put("x-mock-match-request-headers", "header");
		
		Headers extractHeaders = given(). //Headers object creation // extractedheaders ref variable will store all the headers available
			baseUri("https://8c130e85-619a-4e78-8ccd-04d0541bc49b.mock.pstmn.io").
			headers(headersMap).
			log().headers().
		when().
			get("/get").
		then().
			log().all().
			assertThat().
			statusCode(200).
			extract().
			headers();
		
		List<String> values = extractHeaders.getValues("multiValueResponseHeader"); // List is used for storing the multiple values of a single header
		for(String value:values)
		{
			System.out.println("Header value is: "+value);
		}
	}
}
