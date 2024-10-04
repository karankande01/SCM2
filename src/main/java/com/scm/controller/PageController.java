package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.dto.UserForm;
import com.scm.entity.User;
import com.scm.exception.Message;
import com.scm.exception.MessageType;
import com.scm.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PageController {


    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");
        model.addAttribute("name","TheRapidHire");
        model.addAttribute("spring_initializer","https://start.spring.io/" );
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("isLogin", false);
        System.out.println("About page handler");
        return "about"; 
    }

    @GetMapping("/services")
    public String services(Model model){
        System.out.println("Service page handler");
        return "services";
    }

    @GetMapping(path = "/contact")
    public String contact(Model model) {
        System.out.println("Contact page handler");
        return "contact";
    }

    @GetMapping(path = "/login")
    public String login(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("user", userForm);
        System.out.println("Login page handler");
        return "login";
    }

    @GetMapping(path = "/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("user", userForm);
        return "register";
    }

    @PostMapping("/do-register")
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, HttpSession session, Model model) {
        System.out.println("processing registration");
        System.out.println(userForm);

        //validate form data
        if(bindingResult.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            model.addAttribute("user", userForm); // Make sure to use "user" key
        
            return "register";
        }

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("profilepic.jpg");

        User savedUser = userService.saveUser(user);
        System.out.println("User saved!!");
        Message message =  Message.builder().content("Registration successful").type(MessageType.green).build();
        session.setAttribute("message", message);
        return "redirect:/register";
    }
    

    

}
