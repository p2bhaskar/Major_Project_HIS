package com.pb.citizen_api.controller;

import com.pb.citizen_api.dto.ApplicationForm;
import com.pb.citizen_api.model.Application;
import com.pb.citizen_api.serviceImpl.ApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ApplicationServiceImpl applicationService;

    @PostMapping("/submit_app")
    List<Application> submitApplication(@RequestBody ApplicationForm applicationForm){
       return applicationService.submitApplication(applicationForm);
    }


}
