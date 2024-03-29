package com.example.taxiexpressv2.Entities;

//import com.example.taxiexpressv2.Entities.usr.Users;
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
/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("E")*/
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int idEmploye;
    private String firstName;
    private String lastName;
    private String homeAdress ;
    private String email;
    private String phoneNumber;
    private String password ;


    @ManyToOne
    private access access;
    @OneToMany
    private List<PickUpRequest> pickUpRequestList;

    public Employee(String firstName, String lastName, String email, String phoneNumber, String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email =email ;
        this.phoneNumber = phoneNumber;
        this.password =password ;
    }
}
