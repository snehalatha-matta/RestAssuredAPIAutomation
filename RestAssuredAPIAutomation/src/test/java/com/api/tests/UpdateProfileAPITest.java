package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.GetProfileResponse;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileAPITest {

	@Test(description= "Verify if UpdateProfile API is working")
	public void UpdateProfileTest() {
		
		LoginRequest loginRequest = new LoginRequest("uday4321","uday4321");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("----------------------------------------------------");
		
		
		  UserManagementService userManagementService = new UserManagementService();
		  response = userManagementService.getProfile(loginResponse.getToken());
		  System.out.println(response.asPrettyString()); GetProfileResponse
		  getProfileResponse = response.as(GetProfileResponse.class);
		  Assert.assertEquals(getProfileResponse.getUsername(), "uday4321");
		  
		  System.out.println("----------------------------------------------------");
		  
		  UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest.Builder() 
		  .email("tisha12345@gmail.com")
		  .firstName("Tisha123456") 
		  .lastName("Tillaiiii") 
		  .mobileNumber("8427511453")
		  .build();
		  
		  userManagementService.updateProfile(loginResponse.getToken(),updateProfileRequest); 
		  System.out.println(response.asPrettyString());
		 
	}
}
