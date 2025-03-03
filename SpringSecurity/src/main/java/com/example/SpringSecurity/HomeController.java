package com.example.SpringSecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String test(){
        return "Home.jsp";
    }
    @RequestMapping("/login")
    public String login(){
        return "Login.jsp";
    }
    @RequestMapping("/logout-success")
    public String logout(){
        return "Logout.jsp";
    }

    @RequestMapping("user")
    @ResponseBody
    public Principal user(Principal principal){
        return principal;
    }
}
