package com.example.taxiexpressv2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EnableJpaAuditing
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
    private String carModel ;
    @CreatedDate
   // @Temporal(TemporalType.TIMESTAMP)
    @Temporal(TemporalType.DATE)
    //Column(name = "created_at"
    private Date createdAt;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private boolean status;

    @OneToMany
    private List<PickUpRequest> pickUpRequests;

    @OneToMany
    private List<Courses> coursesList;


}
