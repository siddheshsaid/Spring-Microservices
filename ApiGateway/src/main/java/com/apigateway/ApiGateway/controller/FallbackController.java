package com.apigateway.ApiGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/userServiceFallback")
    public String userServiceFallBack(){
        return "User service is down at this time !!";
    }

    @GetMapping("/contactServiceFallback")
    public String contactServiceFallback(){
        return "Contact service is down at this time";
    }
}
