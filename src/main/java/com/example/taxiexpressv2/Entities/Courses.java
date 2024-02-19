package com.example.taxiexpressv2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Courses implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int idCourse;
    private String pasengers ;
    @Enumerated(EnumType.STRING)
    private  CourseType courseType;
    private boolean status;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @OneToOne
    private PickUpRequest pickUpRequest;
}
