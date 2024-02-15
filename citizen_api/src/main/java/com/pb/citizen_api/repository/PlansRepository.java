package com.pb.citizen_api.repository;

import com.pb.citizen_api.model.Plans;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PlansRepository extends CrudRepository<Plans,Long> {

    @Query("SELECT p.planName FROM Plans p")
    List<String> findAllPlansNames();


    Plans findByPlanName(String name);
}
