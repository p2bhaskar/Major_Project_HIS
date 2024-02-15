package com.pb.citizen_api.service;

import com.pb.citizen_api.model.Plans;

import java.util.List;

public interface PlansService {

    String createPlan(Plans plan);

    List<String> findAllPlansNames();

    Plans findByPlanName(String name);
}
