package com.example.taxiexpressv2.Controllers;

import com.example.taxiexpressv2.Entities.usr.Role;
import com.example.taxiexpressv2.Entities.usr.UserRole;
import com.example.taxiexpressv2.Entities.usr.Users;
import com.example.taxiexpressv2.Helpers.UserFoundException;
import com.example.taxiexpressv2.Services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.HashSet;
import java.util.Set;





@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController extends BaseController<Users, Integer>{

	
	@Autowired
	private UserServiceInterface userService;

	@PermitAll
	@PostMapping("/register")
	public Users register(@RequestBody Users user) throws Exception {
		
		Set<UserRole>roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);

		return this.userService.register(user, roles);
		
	}
	@PermitAll
	@PostMapping("/registerAdmin")
	public Users registerAdmin(@RequestBody Users user) throws Exception {

		Set<UserRole>roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("Admin");
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);

		return this.userService.register(user, roles);

	}
	
	@GetMapping("/{username}")
	public Users getUser(@PathVariable("username")String username) {
		return this.userService.getUserByUsername(username);
	}
	
	
	
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?>exceptionHandler(UserFoundException ex){
	return null;	

	}
	
	
	
}
