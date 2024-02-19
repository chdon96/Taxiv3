package com.example.taxiexpressv2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Taxi implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int idTaxi;
    private String fullName;
    private String email;
    private long phoneNumber;
    private String homeAdress;
    private String Numberplate;
    private int matricule ;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    private boolean status;

    @OneToMany
    private List<PickUpRequest> pickUpRequests;

    @OneToMany
    private List<Courses> coursesList;


}
