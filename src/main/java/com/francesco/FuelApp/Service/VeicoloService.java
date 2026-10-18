package com.francesco.FuelApp.Service; 

import org.springframework.stereotype.Service;
import com.francesco.FuelApp.Model.VeicoloModel;
import com.francesco.FuelApp.Repository.VeicoloRepo;
import com.francesco.FuelApp.DTO.NewVeicoloReq;

import java.util.List;
import java.util.Optional;


@Service
public class VeicoloService
{
    private final VeicoloRepo veicoloRepo;

    public VeicoloService(VeicoloRepo veicoloRepo) 
    {
        this.veicoloRepo = veicoloRepo;
    }

    public VeicoloModel createVeicolo(NewVeicoloReq request, Long idUser) 
    {
        VeicoloModel veicolo = new VeicoloModel();
        veicolo.setNomeVeicolo(request.getNomeVeicolo());
        veicolo.setIdUser(idUser);
        veicoloRepo.save(veicolo);
        return veicolo;
    }

    public List<VeicoloModel> getVeicoli(Long idUser) 
    {
        return veicoloRepo.findByIdUser(idUser);
    }

    public void deleteVeicolo(Long idVeicolo, Long idUser) 
    {
        VeicoloModel veicolo = veicoloRepo.findById(idVeicolo).orElse(null);
        if (veicolo == null) 
        {
            throw new RuntimeException("Vehicle not found");
        }
        if (!veicolo.getIdUser().equals(idUser)) 
        {
            throw new RuntimeException("You are not authorized to delete this vehicle");
        }
        veicoloRepo.delete(veicolo);
    }

}