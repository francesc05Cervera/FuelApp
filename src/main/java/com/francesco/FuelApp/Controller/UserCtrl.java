package com.francesco.FuelApp.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.ResponseEntity;

import com.francesco.FuelApp.Model.UserModel;
import com.francesco.FuelApp.Service.UserService;
import com.francesco.FuelApp.Repository.UserRepo;

import com.francesco.FuelApp.DTO.RegisterReq;
import com.francesco.FuelApp.DTO.RegisterResp;

@RestController 
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserCtrl {

    private final UserService userService;

    public UserCtrl(UserService userService)
    {
    
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<RegisterResp> registerUser(@RequestBody RegisterReq request)
    {
        try
        {
            RegisterResp response = userService.registerUser(request);
            
            if (response == null) 
            {
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok(response);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody RegisterReq request)
    {
        try
        {
            String token = userService.loginUser(request);
            
            if (token == null) 
            {
                return ResponseEntity.status(401).body("Invalid email or password");
            }

            return ResponseEntity.ok(token);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Internal server error");
        }
    }

    @GetMapping ("/profile")
    public ResponseEntity<UserModel> getUserProfile(@RequestHeader("Authorization") String token)
    {
        try
        {
            UserModel user = userService.getUser(token);
            return ResponseEntity.ok(user);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).body(null);
        }
    }
}