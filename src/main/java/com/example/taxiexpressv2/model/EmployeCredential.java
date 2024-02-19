package com.example.taxiexpressv2.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employe_credentials")
public class EmployeCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String password;
    private String verificationCode;
    private boolean isVerified = false;
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;



    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public Boolean getIsVerified() {
        return isVerified;
    }
    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
}
