package com.pb.citizen_api;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Citizen microservice REST API Documentation",
				description = "AshokIt Major Project (HIS) microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Pranav Bhaskar",
						email = "p2bhaskar@gmail.com",
						url = "https://www.ashokitech.com"
				),
				license = @License(
						name = "Apache 2.0",
						url =  "https://www.ashokitech.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "AshokIt Major Project (HIS) microservice REST API Documentation",
				url = "https://www.ashokitech.com/swagger-ui.html"
		)
)
public class CitizenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitizenApiApplication.class, args);
	}

}
