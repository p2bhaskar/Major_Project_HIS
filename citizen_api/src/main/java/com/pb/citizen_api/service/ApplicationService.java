package com.pb.citizen_api.service;

import com.pb.citizen_api.dto.ApplicationForm;
import com.pb.citizen_api.model.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> submitApplication(ApplicationForm applicationForm);
}
