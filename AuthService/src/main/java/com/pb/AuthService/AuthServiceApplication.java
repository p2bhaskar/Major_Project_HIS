package com.pb.AuthService;

import com.pb.AuthService.clients.LoginResponseFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AuthServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
