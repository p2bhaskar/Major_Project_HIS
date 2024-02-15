package com.pb.citizen_api.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "citizen_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long citizen_id;

    private Long ssn;

    private String name;

    private String email;

    private String password;

    private String gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dob;

/*    //@OneToMany(mappedBy = "citizen", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OneToMany
    @JsonIgnore
    private List<Application> applicationList;
   //private String current_age;*/


}
