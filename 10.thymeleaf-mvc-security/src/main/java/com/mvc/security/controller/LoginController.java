package com.mvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
// (Login controller = security controller)
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

//        return "plain-login";
        return "fancy-login";
    }

    // add request mapping for /acces-denied
    @GetMapping("/access-denied")
    public String showAccesDenied(){
        return "access-denied";
    }



}
