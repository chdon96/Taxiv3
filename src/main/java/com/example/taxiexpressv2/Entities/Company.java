package com.example.taxiexpressv2.Entities;

import com.example.taxiexpressv2.Entities.usr.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.catalina.User;

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
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int idCompany;
    private String companyName;
    private String mainAdress;
    private  long phoneNumber;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    private boolean status;

    @OneToMany//(mappedBy = "company")
    @JsonIgnore
    private List<Department> departments;
    @OneToOne
    public Users Responsable ;


}
