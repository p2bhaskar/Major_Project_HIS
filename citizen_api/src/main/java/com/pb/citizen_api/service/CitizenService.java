package com.pb.citizen_api.service;

import com.pb.citizen_api.dto.RequestDto;
import com.pb.citizen_api.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface CitizenService {

    ResponseDto registerCitizen(RequestDto request);

    String updatePassword(String email);

    ResponseDto citizenDashboard(String email);



}
