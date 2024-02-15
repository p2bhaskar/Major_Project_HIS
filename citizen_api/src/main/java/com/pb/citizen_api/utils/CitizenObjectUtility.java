package com.pb.citizen_api.utils;

import com.pb.citizen_api.dto.ApplicationForm;
import com.pb.citizen_api.dto.RequestDto;
import com.pb.citizen_api.dto.ResponseDto;
import com.pb.citizen_api.model.Application;
import com.pb.citizen_api.model.Citizen;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class CitizenObjectUtility {

    public ResponseDto mapToResponseDto(Citizen citizen){
        ResponseDto response = new ResponseDto();

        response.setSsn(citizen.getSsn());
        response.setName(citizen.getName());
        response.setEmail(citizen.getEmail());
        response.setDob(citizen.getDob());
        response.setGender(citizen.getGender());

        return response;



    }

    public Citizen mapToCitizen(RequestDto request){
        Citizen citizen = new Citizen();

        citizen.setSsn(request.getSsn());
        citizen.setName(request.getName());
        citizen.setEmail(request.getEmail());
        citizen.setGender(request.getGender());
        String hashedPwd = encode(request.getPassword());
        citizen.setPassword(hashedPwd);
        citizen.setDob(request.getDob());


        return citizen;
    }



    public static String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
