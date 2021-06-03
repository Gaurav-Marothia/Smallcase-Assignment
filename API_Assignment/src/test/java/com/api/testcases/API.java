package com.api.testcases;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class API {

	@Test
	public void verifyJsonSchema() {
		

		// GIVEN
		RestAssured
			.given()
				.baseUri("https://bookstore.toolsqa.com/BookStore/v1/Books")
		// WHEN
			.when()
				.get()
		// THEN
			.then()
				.assertThat()
				.statusCode(200)
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));
	}
}
