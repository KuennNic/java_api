package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class JenkinsWebhookController {
    //Jenkins webhook Simulation: Handles POST requests from jenkins
    public String handleJenkinsWebhook(@RequestBody String payload) {
        //Log incoming payload
        System.out.println("Received Jenkins webhook: " + payload);

        //In real world you would trigger actions such as deployment
        return "Jenkins webhook recieved";
    }
}
