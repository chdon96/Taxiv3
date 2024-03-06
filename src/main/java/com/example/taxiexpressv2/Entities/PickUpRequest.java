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
public class PickUpRequest implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int idpickUp;
    @Temporal(TemporalType.DATE)
    private Date pickupdate;
    @Temporal(TemporalType.TIME)
    private Date pickUpTime;



    @Temporal(TemporalType.DATE)
    private Date createdAt;
    private boolean status ;

    @OneToMany
    private List<Employee> passengers;

    @OneToOne
    private Courses course;

    @ManyToOne
    private Taxi taxi;


}
