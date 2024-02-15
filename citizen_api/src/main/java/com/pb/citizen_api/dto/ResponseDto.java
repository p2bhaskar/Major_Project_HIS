package com.pb.citizen_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDto {


    private Long ssn;


    private String name;


    private String email;



    private String gender;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dob;
}
