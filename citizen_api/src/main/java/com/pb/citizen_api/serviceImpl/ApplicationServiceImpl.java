package com.pb.citizen_api.serviceImpl;


import com.pb.citizen_api.clients.SsaWebFiegnClient;
import com.pb.citizen_api.dto.ApplicationForm;
import com.pb.citizen_api.model.Application;
import com.pb.citizen_api.model.Citizen;
import com.pb.citizen_api.model.Plans;
import com.pb.citizen_api.repository.ApplicationRepository;
import com.pb.citizen_api.repository.CitizenRepository;
import com.pb.citizen_api.repository.PlansRepository;
import com.pb.citizen_api.service.ApplicationService;
import com.pb.citizen_api.utils.AppNumUtil;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    PlansRepository plansRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    SsaWebFiegnClient ssaWebFiegnClient;

String str = "user";
    @Override
    public List<Application> submitApplication(ApplicationForm applicationForm) {
        String stateName = ssaWebFiegnClient.getStateName(applicationForm.getSsn());
       // Application application =new Application();

        if(stateName.equals("Rhode Island")){
            Application application =new Application();
            application.setApplication_no(AppNumUtil.generateApplicationNumber());
            Citizen citizen = citizenRepository.findByName(applicationForm.getName());
            System.out.println(citizen);
           // application.setCitizen_id(citizen.getCitizen_id());
            application.setCitizen(citizen);


            Plans plans  = plansRepository.findByPlanName(applicationForm.getPlans_name());
           // application.setPlans_id(plans.getPlans_id());
            application.setPlans(plans);
            applicationRepository.save(application);

            return (List<Application>) applicationRepository.findAll();



        }else {
             throw new OpenApiResourceNotFoundException("No Such SSN exist");
        }


       // return null;
    }
}
