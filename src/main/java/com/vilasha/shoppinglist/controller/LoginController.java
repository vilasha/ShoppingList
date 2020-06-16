package com.vilasha.shoppinglist.controller;

import com.vilasha.shoppinglist.service.UserRepresentation;
import com.vilasha.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRepresentation());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("user") UserRepresentation userRepresentation, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "register";
        if (!userRepresentation.getPassword().equals(userRepresentation.getRepeatPassword()))
            bindingResult.rejectValue("password", "Passwords don't match");

        userService.createUser(userRepresentation);
        return "redirect:/login";
    }
}
