package com.pb.AuthService.clients;


import com.pb.AuthService.login_model.Login_Credentials;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "random", url = "http://localhost:8081")

public interface LoginResponseFeignClient {

    @GetMapping("/citizen/login_response") // Relative path
    Login_Credentials getLoginResponse(@RequestParam String email);
}
