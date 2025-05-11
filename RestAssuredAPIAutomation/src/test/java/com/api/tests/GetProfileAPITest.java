package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.GetProfileResponse;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class GetProfileAPITest {

	@Test(description= "Verify if GetProfile API is working")
	
	public void getProfileTest() {
		LoginRequest loginRequest = new LoginRequest("uday4321","uday4321");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		UserManagementService userManagementService = new UserManagementService();
		response = userManagementService.getProfile(loginResponse.getToken());
		GetProfileResponse getProfileResponse = response.as(GetProfileResponse.class);
		System.out.println(getProfileResponse.getUsername());
	}
}
