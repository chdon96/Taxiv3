package com.example.taxiexpressv2.Services;

import com.example.taxiexpressv2.Repositories.EmployeCredentialRepository;
import com.example.taxiexpressv2.model.EmployeCredential;
import com.example.taxiexpressv2.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    EmployeCredentialRepository userCredentialRepository;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
  //  @Autowired
 //   private JavaMailSender javaMailSender;

    public EmployeCredential registerUser(EmployeCredential user) {
        Optional<EmployeCredential> userUsername = userCredentialRepository.findByUsername(user.getUsername());
        Optional<EmployeCredential> userEmail = userCredentialRepository.findByEmail(user.getEmail());
        if (userUsername.isPresent()) {
            throw new RuntimeException("Username taken.");
        }
        if (userEmail.isPresent()) {
            throw new RuntimeException("Email taken.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsActive(false);
        user.setVerificationCode(generateNumericCode(6));
        EmployeCredential savedUser = userCredentialRepository.save(user);
        sendVerificationEmail(savedUser.getEmail(), savedUser.getVerificationCode());

        return userCredentialRepository.save(user);
    }
    @Async
    public void sendVerificationEmail(String email, String code) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Email Verification");
        mailMessage.setText("Your verification code is: " + code);
     //   javaMailSender.send(mailMessage);
    }
    public boolean verifyEmail(String code) {
        Optional<EmployeCredential> user = userCredentialRepository.findByVerificationCode(code);
        if (user.isPresent()) {
            EmployeCredential verifiedUser = user.get();
            verifiedUser.setIsVerified(true);
            verifiedUser.setIsActive(true);
            verifiedUser.setVerificationCode(null);
            userCredentialRepository.save(verifiedUser);
            return true;
        }
        return false;
    }
    public String generateToken(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return jwtService.generateToken(userDetails);
    }


    public Optional<EmployeCredential> getUserByUsername(String username) {
        return userCredentialRepository.findByUsername(username);
    }

    private String generateNumericCode(int length) {
        int number = (int) (Math.random() * Math.pow(10, length));
        return String.format("%0" + length + "d", number);
    }
    public void validate(String token) {
        jwtService.validateToken(token);
    }

    public Optional<EmployeCredential> getUserById(Integer id) {
        return userCredentialRepository.findById(id);
    }

    public List<EmployeCredential> getAllUsersByRole(UserRole role) {
        return userCredentialRepository.findByRole(role);
    }

    public void deleteUser(int id) {
        userCredentialRepository.deleteById(id);
    }
}
