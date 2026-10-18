package com.francesco.FuelApp.DTO;

public class RegisterResp 
{
    private String email; 

    public RegisterResp() {}
    public RegisterResp(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
