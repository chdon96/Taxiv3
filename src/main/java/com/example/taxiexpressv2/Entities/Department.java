package com.example.taxiexpressv2.Entities;

import com.example.taxiexpressv2.Entities.usr.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int idDepartment;
    private String title;
    private boolean status ;

   // @ManyToOne
   // private Company company;
    @OneToOne
    private AdressS departmentAdress;
    @OneToMany
    @JsonIgnore
    private List<Users> employess;
}
