package com.francesco.FuelApp.Service;

import org.springframework.stereotype.Service;

import com.francesco.FuelApp.DTO.RegisterReq;
import com.francesco.FuelApp.Repository.UserRepo;
import com.francesco.FuelApp.Model.UserModel;
import com.francesco.FuelApp.DTO.RegisterResp;
import com.francesco.FuelApp.Security.PasswordService;
import com.francesco.FuelApp.Security.JwtService;


@Service
public class UserService 
{
    private final PasswordService passwordService;
    private final UserRepo userRepo;
    private final JwtService jwtService;

    public UserService(PasswordService passwordService, UserRepo userRepo, JwtService jwtService) 
    {
        this.passwordService = passwordService;
        this.userRepo = userRepo;
        this.jwtService = jwtService;
    }
    
    public RegisterResp registerUser(RegisterReq request) throws Exception
    {
        if(request.getEmail() == null || request.getPassword() == null || 
        request.getEmail().isEmpty() || request.getPassword().isEmpty())
        {
            throw new Exception("Email and password must not be null");
        }

        UserModel user = new UserModel();
        user.setEmail(request.getEmail());
        user.setHashPassword(passwordService.hashPassword(request.getPassword()));
        userRepo.save(user);

        return new RegisterResp(user.getEmail());
    }
    
    public String loginUser(RegisterReq request) throws Exception
    {
        if(request.getEmail() == null || request.getPassword() == null || 
        request.getEmail().isEmpty() || request.getPassword().isEmpty())
        {
            throw new Exception("Email and password must not be null");
        }

        UserModel user = userRepo.findByEmail(request.getEmail());
        if(user == null)
        {
            return null;
        }

        boolean isPasswordValid = passwordService.verifyPassword(request.getPassword(), user.getHashPassword());
        if(!isPasswordValid)
        {
            return null;
        }

        // Generate a token (for simplicity, using email as token)
        return jwtService.generateToken(user.getEmail());
    }

    public UserModel getUser(String token) throws Exception
    {
        String email = jwtService.extractSubject(token);
        if(email.isBlank())
        {
            throw new Exception("Token is invalid or expired");
        }
        return userRepo.findByEmail(email);
    }
}
