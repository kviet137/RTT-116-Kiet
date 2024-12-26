package com.example.module309.controller;


import com.example.module309.database.dao.UserDAO;
import com.example.module309.database.entity.Employee;
import com.example.module309.database.entity.User;
import com.example.module309.form.SignupFormBean;
import com.example.module309.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDAO;


    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    //the mapping need to match the spring security config .. .loginPage method
    @GetMapping("/login/login")
    public ModelAndView createCustomer() {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/loginPage");

        return response;
    }

    @GetMapping("/login/signup")
    public ModelAndView signup() {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/signup");

        return response;
    }

    @PostMapping("/login/signupSubmit")
    public ModelAndView signupSubmit(@Valid SignupFormBean form, BindingResult bindingResult, HttpSession session) {

        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            response.setViewName("login/signup");
            response.addObject("bindingResult", bindingResult); //"bindingResult" is linked to the jsp page
            response.addObject("form", form);
        } else{
            User user = new User();
            user.setEmail(form.getUsername());
            user.setFullName(form.getFullname());

            String encryptedPassword = passwordEncoder.encode(form.getPassword());
            user.setPassword(encryptedPassword);

            userDAO.save(user);

            authenticatedUserService.changeLoggedInUsername(session, form.getUsername(), form.getPassword());

            response.setViewName("redirect:/");
        }



        return response;

    }

}
