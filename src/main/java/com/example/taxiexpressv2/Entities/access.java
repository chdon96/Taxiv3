package com.example.taxiexpressv2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

     /*   @Column(columnDefinition = "TEXT")
        private String dynamicAttributesJson;*/
      /*  @ElementCollection
        private Map<String, Object>
                dynamicAttributes = new HashMap<>();*/

        // getters and setters
     /*   private boolean accesAdmin;
        private boolean accessTaxi;
        private boolean accessClient;*/
        @Column(columnDefinition = "TEXT")
        private String dynamicAttributesJson;

        // getters and setters

        @Transient
        public Map<String, Object> getDynamicAttributes() {
                if (dynamicAttributesJson == null) {
                        return new HashMap<>();
                }

                try {
                        ObjectMapper mapper = new ObjectMapper();
                        return mapper.readValue(dynamicAttributesJson, new TypeReference<Map<String, Object>>() {});
                } catch (IOException e) {
                        // handle exception
                }

                return new HashMap<>();
        }

        @Transient
        public void setDynamicAttributes(Map<String, Object> dynamicAttributes) {
                try {
                        ObjectMapper mapper = new ObjectMapper();
                        this.dynamicAttributesJson = mapper.writeValueAsString(dynamicAttributes);
                } catch (JsonProcessingException e) {
                        // handle exception
                }
        }
}


