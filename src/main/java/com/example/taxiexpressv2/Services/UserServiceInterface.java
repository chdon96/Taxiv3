package com.example.taxiexpressv2.Services;

import com.example.taxiexpressv2.Entities.usr.UserRole;
import com.example.taxiexpressv2.Entities.usr.Users;


import java.util.Set;

public interface UserServiceInterface extends BaseServiceInterface<Users, Integer>{
	
	
	public Users register(Users user, Set<UserRole>userRole) throws Exception;


	//Get users by username
	public Users getUserByUsername(String username);




}
