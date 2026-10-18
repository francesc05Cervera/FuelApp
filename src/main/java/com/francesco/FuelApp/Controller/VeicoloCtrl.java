package com.francesco.FuelApp.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;

import com.francesco.FuelApp.Model.VeicoloModel;
import com.francesco.FuelApp.Service.VeicoloService;
import com.francesco.FuelApp.Service.UserService;
import com.francesco.FuelApp.DTO.NewVeicoloReq;

@RestController 
@RequestMapping("/api/veicolo")
public class VeicoloCtrl 
{
    private final VeicoloService veicoloService;
    private final UserService userService;
    public VeicoloCtrl(VeicoloService veicoloService, UserService userService) 
    {
        this.veicoloService = veicoloService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createVeicolo(@RequestHeader ("Authorization") String token, 
                                                @RequestBody NewVeicoloReq request) 
    {
        try
        {
            veicoloService.createVeicolo(request, userService.getUser(token).getId()); 

        } catch(Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Vehicle created successfully");
    }

    @GetMapping 
    public ResponseEntity<Object> getVeicoli(@RequestHeader ("Authorization") String token) 
    {
        try
        {
            return ResponseEntity.ok().body(veicoloService.getVeicoli(userService.getUser(token).getId())); 

        } catch(Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping 
    public ResponseEntity<Object> delete(@RequestHeader("Authorization") String token, @RequestBody Long idVeicolo) 
    {
        try
        {
            veicoloService.deleteVeicolo(idVeicolo, userService.getUser(token).getId());
            return ResponseEntity.ok().body("Vehicle deleted successfully");

        } catch(Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}