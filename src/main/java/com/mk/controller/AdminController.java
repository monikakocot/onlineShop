package com.mk.controller;

import com.mk.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdminController {

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
    @PostMapping("/login")
    public String loginUser(@ModelAttribute @Valid LoginForm loginForm, BindingResult bindingResult, Model model){


        if(loginForm.getUserName().equals("administrator") && loginForm.getPassword().equals("adminadmin")){
            return "afterLogin";
        }
        if(bindingResult.hasErrors()){
            return "login";
        }

        return "redirect:/";
    }

}
