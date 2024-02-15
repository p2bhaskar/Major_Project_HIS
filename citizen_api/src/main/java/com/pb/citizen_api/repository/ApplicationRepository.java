package com.pb.citizen_api.repository;

import com.pb.citizen_api.model.Application;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ApplicationRepository extends CrudRepository<Application,String> {



        @Query("SELECT a FROM Application a WHERE a.citizen.name = :citizenName AND a.plans.planName = :plansName")
        Application findByCitizenAndPlans(@Param("citizenName") String citizenName, @Param("plansName") String plansName);


}
