package com.example.taxiexpressv2.config;

import com.example.taxiexpressv2.Repositories.EmployeCredentialRepository;
import com.example.taxiexpressv2.model.EmployeCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeCredentialRepository userCredentialRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeCredential> userCredential = userCredentialRepository.findByUsername(username);
        return userCredential.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found with name :" + username));
    }
}
