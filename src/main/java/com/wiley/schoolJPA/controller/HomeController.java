package com.wiley.schoolJPA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/home")
@CrossOrigin
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}