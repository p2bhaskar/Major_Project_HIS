package com.pb.AuthService.clients;


import com.pb.AuthService.login_model.Citizen_Dashbord;
import com.pb.AuthService.login_model.Login_Credentials;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "random2", url = "http://localhost:8081")
public interface CitizenDashboardFiegnClient {

    @GetMapping("/citizen/dashboard") // Relative path
    Citizen_Dashbord getDashboardResponse(@RequestParam String email);
}
