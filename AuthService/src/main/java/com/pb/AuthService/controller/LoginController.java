package com.pb.AuthService.controller;



import com.pb.AuthService.clients.CitizenDashboardFiegnClient;
import com.pb.AuthService.clients.LoginResponseFeignClient;
import com.pb.AuthService.login_model.Citizen_Dashbord;
import com.pb.AuthService.login_model.Login_Credentials;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController
{

    @Autowired
    private CitizenDashboardFiegnClient citizenDashboardFiegnClient;

/*    @PostMapping("/login")
   // @CrossOrigin("*")
    public String login(Authentication authentication)
    {
        System.out.println(authentication.getName());
       String response = "login Successful !!!!**** "+authentication.getName();
       return response;
    }*/

    @PostMapping("/login")

    public Citizen_Dashbord login(Authentication authentication)
    {
       // System.out.println(authentication.getName());
        Citizen_Dashbord dashbord = new Citizen_Dashbord();
        dashbord = citizenDashboardFiegnClient.getDashboardResponse(authentication.getName());
        return dashbord;
    }





   /* @PostMapping("/login2")
    public Login_Credentials getLoginResponse(@RequestParam String email) {

        Login_Credentials lc = loginResponseFeignClient.getLoginResponse(email);
        System.out.println(lc);
       return lc;
    }
*/
}
