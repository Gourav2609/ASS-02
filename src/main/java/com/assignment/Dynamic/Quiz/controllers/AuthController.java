package com.assignment.Dynamic.Quiz.controllers;

import com.assignment.Dynamic.Quiz.models.LoginForm;
import com.assignment.Dynamic.Quiz.models.User;
import com.assignment.Dynamic.Quiz.models.UserDTO;
import com.assignment.Dynamic.Quiz.models.AuthResponse;
import com.assignment.Dynamic.Quiz.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
        // Retrieve user by email
        User user = userRepo.findByEmail(loginForm.getEmail());

        if (user != null && user.getPassword().equals(loginForm.getPassword())) {
            UserDTO userDTO = new UserDTO(user.getUserId(), user.getUsername() , user.getEmail());
            AuthResponse authResponse = new AuthResponse("Login successful", userDTO);

            // Convert AuthResponse to JSON
            String jsonResponse = authResponse.toJson();

            // Return JSON response
            return ResponseEntity.ok(jsonResponse);
        } else {
            // Authentication failed
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
