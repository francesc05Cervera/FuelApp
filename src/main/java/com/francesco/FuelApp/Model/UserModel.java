package com.francesco.FuelApp.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "app_user")
public class UserModel 
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = false, nullable = true)
    private String hashPassword; 

    public UserModel() {} 
    public UserModel(Long id, String email, String hashPassword)
    {
        this.email = email; 
        this.id = id;
        this.hashPassword = hashPassword;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getHashPassword()
    {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword)
    {
        this.hashPassword = hashPassword;
    }
}