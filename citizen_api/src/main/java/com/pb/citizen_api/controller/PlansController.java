package com.pb.citizen_api.controller;


import com.pb.citizen_api.model.Plans;
import com.pb.citizen_api.serviceImpl.PlansServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlansController {

    @Autowired
    PlansServiceImpl plansService;

    @PostMapping("/add_plan")
    String createPlan(@RequestBody Plans plan){
        return plansService.createPlan(plan);
    }
}
