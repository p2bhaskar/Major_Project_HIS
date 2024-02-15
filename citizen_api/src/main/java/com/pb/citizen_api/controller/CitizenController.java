package com.pb.citizen_api.controller;

import com.pb.citizen_api.dto.LoginResponse;
import com.pb.citizen_api.dto.RequestDto;
import com.pb.citizen_api.dto.ResponseDto;
import com.pb.citizen_api.dto.ServiceResponseDto;
import com.pb.citizen_api.repository.CitizenRepository;
import com.pb.citizen_api.serviceImpl.CitizenServiceImplementation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
    @Autowired
    CitizenServiceImplementation citizenServiceImplementation;
    @Autowired
    CitizenRepository repository;


    @Operation(
            summary = "Create Citizen REST API",
            description = "REST API to create new Citizen as User"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"

            )
    }
    )
    @PostMapping("/register")
    public ServiceResponseDto<ResponseDto> registerCitizen(@RequestBody @Valid RequestDto request){

        ServiceResponseDto<ResponseDto> serviceResponse = new ServiceResponseDto<>();
        ResponseDto response = citizenServiceImplementation.registerCitizen(request);
        serviceResponse.setStatus(HttpStatus.OK);
        serviceResponse.setResponse(response);

        return serviceResponse;
    }

    @GetMapping("/login_response")
    LoginResponse getLoginResponse(@RequestParam String email){
        List<LoginResponse> responseList = repository.findEmailAndPasswordByEmail(email);
        LoginResponse response = null;
        if(responseList.size()>0) {
            response =  responseList.get(0);
        }else{
            throw new RuntimeException("User not found with given email..");
        }
         return response;
    }


    @GetMapping("/dashboard")
    ResponseEntity<ResponseDto> citizenDashboard(@RequestParam String email){
        ResponseDto response =  citizenServiceImplementation.citizenDashboard(email);

        return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
    }




    @PutMapping("/update_pwd")
    ResponseEntity<String> updatePwd(@RequestParam String email){
       String msg =  citizenServiceImplementation.updatePassword(email);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
