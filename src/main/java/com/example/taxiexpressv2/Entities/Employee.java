package com.example.taxiexpressv2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int idEmploye;
    private String firstName;
    private String lastName;
    private String homeAdress ;
    private String email;
    private String password ;

    @ManyToOne
    private Department department;
    @ManyToOne
    private access access;
    @OneToMany
    private List<PickUpRequest> pickUpRequestList;
}
