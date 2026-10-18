package com.francesco.FuelApp.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.francesco.FuelApp.Model.VeicoloModel;

@Repository
public interface VeicoloRepo extends JpaRepository<VeicoloModel, Long> 
{
    VeicoloModel findById(long id);
    VeicoloModel findByNomeVeicolo(String NomeVeicolo);
    List<VeicoloModel> findByIdUser(Long idUser);
    
}
