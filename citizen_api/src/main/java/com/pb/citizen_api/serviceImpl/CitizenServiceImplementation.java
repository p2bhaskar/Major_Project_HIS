package com.pb.citizen_api.serviceImpl;

import com.pb.citizen_api.dto.EmailRequest;
import com.pb.citizen_api.dto.RequestDto;
import com.pb.citizen_api.dto.ResponseDto;
import com.pb.citizen_api.model.Citizen;
import com.pb.citizen_api.repository.CitizenRepository;
import com.pb.citizen_api.service.CitizenService;
import com.pb.citizen_api.utils.CitizenObjectUtility;
import com.pb.citizen_api.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
public class CitizenServiceImplementation implements CitizenService {

    @Autowired
   private CitizenObjectUtility util;

    @Autowired
    private CitizenRepository repository;

    @Autowired
    private EmailService emailService;
    @Override
    public ResponseDto registerCitizen(RequestDto request) {

        Citizen citizen = util.mapToCitizen(request);

        Citizen savedCitizen = null;
        try{
            savedCitizen = repository.save(citizen);
            return util.mapToResponseDto(savedCitizen);

        }catch(Exception exception){
            throw new RuntimeException("Registration Failed...");
        }

    }

    @Override
    public String updatePassword(String email) {
        Citizen citizen = repository.findByEmail(email);
        String tempPwd = PasswordUtil.generatePassword(5);
        String hashedPwd = CitizenObjectUtility.encode(tempPwd);
        citizen.setPassword(hashedPwd);
        repository.save(citizen);
        EmailRequest emailRequest = new EmailRequest();

        emailRequest.setToEmail(email);
        emailRequest.setSubject("Password Reset");
        emailRequest.setMessageBody("Here is your 5 character temporary password: " + tempPwd);

        emailService.sendSimpleEmail(emailRequest);



        return "Your password is sent to your registered email";
    }

    @Override
    public ResponseDto citizenDashboard(String email) {

        Citizen citizen = repository.findByEmail(email);
        return util.mapToResponseDto(citizen);
    }


}
