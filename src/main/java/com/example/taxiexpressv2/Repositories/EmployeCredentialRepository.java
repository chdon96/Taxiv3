package com.example.taxiexpressv2.Repositories;

import com.example.taxiexpressv2.model.EmployeCredential;
import com.example.taxiexpressv2.model.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeCredentialRepository extends JpaRepository<EmployeCredential, Integer> {

    Optional<EmployeCredential> findByUsername(String username);

    Optional<EmployeCredential> findByEmail(String email);

    Optional<EmployeCredential> findByVerificationCode(String verificationCode);

    List<EmployeCredential> findByRole(UserRole role);
}
