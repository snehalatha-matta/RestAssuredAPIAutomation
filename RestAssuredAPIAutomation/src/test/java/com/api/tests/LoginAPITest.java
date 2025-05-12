package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {

	@Test(description= "Verify if Login API is working")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("uday4321","uday4321");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		Assert.assertTrue(loginResponse.getToken() != null);
		//Assert.assertEquals(loginResponse.getEmail(), "uday4321@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 680);
	}
}
