package com.assignment.Dynamic.Quiz.controllers;

// import java.util.ArrayList;
import java.util.List;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.assignment.Dynamic.Quiz.models.User;
import com.assignment.Dynamic.Quiz.models.UserRepository;

@Controller
public class UserController {
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users/view")
    public String viewUsers(Model model) {
        System.out.println("Viewing users");
        List<User> users = userRepo.findAll();

        model.addAttribute("users", users);
        return "users";
    }

}
