package com.example.taxiexpressv2.Repositories.usr;


import com.example.taxiexpressv2.Entities.usr.UserRole;
import com.example.taxiexpressv2.Entities.usr.Users;


public interface UserRepository extends  BaseRepository<Users, Integer>  {

	public Users findByUsername(String username);

	
	
}
