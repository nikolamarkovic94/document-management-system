package com.nst.dms.controllers;

import com.nst.dms.domain.User;
import com.nst.dms.security.SecurityService;
import com.nst.dms.security.UserValidator;
import com.nst.dms.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;

/**
 * Created by nmarkovi on 5/1/18.
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserValidator userValidator;

//    @GetMapping(value = "/registration")
//    public ModelAndView loginPage() {
//        ModelAndView modelAndView = new ModelAndView("login");
//        return modelAndView;
//    }
//
//    @PostMapping(value = "/registration")
//    public ModelAndView registration(@ModelAttribute("userDetails") User user, BindingResult bindingResult, ModelAndView modelAndView) {
//        userValidator.validate(user, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            throw new LoginException();
//        }
//
//        userService.save(user);
//
//        securityService.autologin(user.getUserName(), user.getPassword());
//
//        return new ModelAndView("documentTypesView");
//    }

    @GetMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView, String error, String logout) {
        if (error != null)
            modelAndView.addObject("error", "Your username and password is invalid.");

        if (logout != null)
            modelAndView.addObject("message", "You have been logged out successfully.");

        return new ModelAndView("login");
    }

}
