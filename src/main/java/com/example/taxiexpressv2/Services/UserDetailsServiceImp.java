package com.example.taxiexpressv2.Services;

import com.example.taxiexpressv2.Repositories.usr.UserRepository;
import com.example.taxiexpressv2.Entities.usr.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		

		Users user = this.userRepo.findByUsername(username);		
		
		if(user == null) {
			System.out.println("User not found !");
			throw new UsernameNotFoundException("User not found");
		}
		
		
		
		return user;
	}

}
