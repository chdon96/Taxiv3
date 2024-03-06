package com.example.taxiexpressv2.Entities.usr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name = "USERS")*/
public class Users implements UserDetails{
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private boolean enabled = true;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="user")
	@JsonIgnore
	private Set<UserRole>userRole = new HashSet<>() ;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		Set<Authority>set = new HashSet<>();
		
		this.userRole.forEach(userRole->{
			set.add(new Authority(userRole.getRole().getRoleName()));
		});
		
		
		return set;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
