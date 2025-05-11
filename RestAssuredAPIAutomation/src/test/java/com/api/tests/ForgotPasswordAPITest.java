package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class ForgotPasswordAPITest {

	@Test(description= "Verify if ForgotPassword API is working")
	
		public void forgotPasswordTest() {
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("jisha12345@gmail.com");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
	}
}
