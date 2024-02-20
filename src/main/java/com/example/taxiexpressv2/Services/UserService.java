package com.example.taxiexpressv2.Services;

import com.example.taxiexpressv2.Entities.usr.UserRole;
import com.example.taxiexpressv2.Entities.usr.Users;
import com.example.taxiexpressv2.Repositories.usr.RoleRepository;
import com.example.taxiexpressv2.Repositories.usr.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService extends BaseServiceImp<Users,Integer> implements UserServiceInterface{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	
	
	@Override
	public Users register(Users user, Set<UserRole> userRoles) throws Exception {
		
		Users local = this.userRepo.findByUsername(user.getUsername());
		
		if(local!=null) {
			//System.out.println("user exist");
			throw new Exception("Utilisateur deja exit");
		}else {
			
			for(UserRole ur : userRoles) {
				roleRepo.save(ur.getRole());
			}
			
			user.getUserRole().addAll(userRoles);
			local = this.userRepo.save(user);

		}
		
		
		return local;
	}



	@Override
	public Users getUserByUsername(String username) {
		return this.userRepo.findByUsername(username);

	}

}
