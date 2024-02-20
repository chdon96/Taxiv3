package com.example.taxiexpressv2.Entities.usr;

import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userRoleId;
	
	
	@ManyToOne(fetch= FetchType.EAGER)
	private Users user;
	
	@ManyToOne
	private Role role;
	
	
}
