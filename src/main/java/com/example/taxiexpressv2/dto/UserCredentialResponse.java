package com.example.taxiexpressv2.dto;

import com.example.taxiexpressv2.model.EmployeCredential;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCredentialResponse {
    private String token;
    private EmployeCredential user;
}
