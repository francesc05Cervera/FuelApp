package com.francesco.FuelApp.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.francesco.FuelApp.Service.RifornimentoService;
import com.francesco.FuelApp.Service.UserService;

import com.francesco.FuelApp.DTO.NewRifornimentoReq;

@RestController 
@RequestMapping ("/api/rifornimento")
public class RifornimentoCtrl 
{
    private final RifornimentoService rifornimentoService;
    private final UserService userService;
    public RifornimentoCtrl(RifornimentoService rifornimentoService, UserService userService) 
    {
        this.rifornimentoService = rifornimentoService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> creaRifornimento(@RequestHeader ("Authorization") String token,
                                                    @RequestBody NewRifornimentoReq request) 
    {
        try
        {
            rifornimentoService.createRifornimento(request, userService.getUser(token).getId()); 

        } catch(Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Rifornimento creato con successo");
    }

    @GetMapping
    public ResponseEntity<Object> getRifornimenti(@RequestHeader ("Authorization") String token)
    {
        try
        {
            return ResponseEntity.ok().body(rifornimentoService.getRifornimenti(userService.getUser(token).getId()));
        } catch(Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping 
    public ResponseEntity<Object> deleteRifornimento(@RequestHeader ("Authorization") String token, @RequestBody Long idRifornimento)
    {
        try
        {
            rifornimentoService.deleteRifornimento(idRifornimento, userService.getUser(token).getId());
        } catch(Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Rifornimento eliminato con successo");
    }
    
}
