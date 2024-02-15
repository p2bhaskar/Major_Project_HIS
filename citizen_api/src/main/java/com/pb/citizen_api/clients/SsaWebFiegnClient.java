package com.pb.citizen_api.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "random3", url = "http://localhost:8080")
public interface SsaWebFiegnClient {

    @GetMapping("/ssn") // Relative path
    String getStateName(@RequestParam Long ssn);
}
