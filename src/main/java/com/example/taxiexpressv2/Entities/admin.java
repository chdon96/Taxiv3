package com.example.taxiexpressv2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class admin implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer idAdmin;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String email;
    @NotBlank
    private long phoneNumber;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date createdAt;







}
