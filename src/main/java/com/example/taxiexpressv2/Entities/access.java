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

public class access implements Serializable {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        private Integer idAcess;
        private String accessName;
        private boolean status;

        private boolean accesAdmin;
        private boolean accessTaxi;
        private boolean accessClient;


}
