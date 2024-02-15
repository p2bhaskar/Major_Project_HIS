package com.pb.citizen_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

 @Min(value = 100000000, message = "SSN must be at least 9 digits")
 @Max(value = 999999999, message = "SSN must be at most 9 digits")
    private Long ssn;

    @NotEmpty(message="Field Name must not be empty")
    private String name;

    @NotEmpty(message="Field Email must not be empty")
    @Email
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$")
    private String password;

    private String gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dob;

}
