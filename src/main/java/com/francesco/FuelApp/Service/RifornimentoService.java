package com.francesco.FuelApp.Service;

import com.francesco.FuelApp.DTO.NewRifornimentoReq;
import com.francesco.FuelApp.Model.RifornimentoModel;
import com.francesco.FuelApp.Repository.RifornimentoRepo;

import java.util.List;

public class RifornimentoService 
{
    private final RifornimentoRepo rifornimentoRepository;
    
    public RifornimentoService(RifornimentoRepo rifornimentoRepository) 
    {
        this.rifornimentoRepository = rifornimentoRepository;
    }

    public void createRifornimento(NewRifornimentoReq request, Long idUser) 
    {
        
        RifornimentoModel rifornimento = new RifornimentoModel();
        rifornimento.setDataRifornimento(request.getDataRifornimento());
        rifornimento.setPrezzoRifornimento(request.getPrezzoRifornimento());
        rifornimento.setLitriRifornimento(request.getLitriRifornimento());
        rifornimento.setPrezzoAlLitro(request.getPrezzoAlLitro());
        rifornimento.setIdVeicolo(request.getIdVeicolo());
        rifornimento.setIdUser(idUser);

        rifornimentoRepository.save(rifornimento);
    }

    public List<RifornimentoModel> getRifornimenti(Long idUser) 
    {
        return rifornimentoRepository.findByIdUser(idUser);
    }

    public void deleteRifornimento(Long idRifornimento, Long idUser) 
    {
        RifornimentoModel rifornimento = rifornimentoRepository.findById(idRifornimento)
                .orElseThrow(() -> new RuntimeException("Rifornimento non trovato"));

        if (!rifornimento.getIdUser().equals(idUser)) 
        {
            throw new RuntimeException("Non sei autorizzato a eliminare questo rifornimento");
        }

        rifornimentoRepository.delete(rifornimento);
    }
    
}
