package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class SignUpAPITest {

	@Test(description= "Verify if SignUp API is working")
	public void signUpTest() {
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
		.userName("jisha12345")
		.password("jisha12345")
		.email("jisha12345@gmail.com")
		.firstName("Jisha12345")
		.lastName("Jillaiii")
		.mobileNumber("7427511454")
		.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);
	}
}
