package com.pb.citizen_api.serviceImpl;

import com.pb.citizen_api.model.Plans;
import com.pb.citizen_api.repository.PlansRepository;
import com.pb.citizen_api.service.PlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlansServiceImpl implements PlansService {

    @Autowired
    PlansRepository plansRepository;


    @Override
    public String createPlan(Plans plan) {
        plansRepository.save(plan);
        return "Plan Saved successfully";
    }

    @Override
    public List<String> findAllPlansNames() {
        return plansRepository.findAllPlansNames();
    }

    @Override
    public Plans findByPlanName(String name) {
        return plansRepository.findByPlanName(name);
    }


}
