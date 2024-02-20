package com.example.taxiexpressv2.Entities.usr;

public class JwtResponse {

	
	String token;
	
	public JwtResponse() {
		
	}
	
	

	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
	
	
}
