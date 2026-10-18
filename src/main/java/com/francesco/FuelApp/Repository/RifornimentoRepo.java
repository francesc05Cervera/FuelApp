package com.francesco.FuelApp.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.francesco.FuelApp.Model.RifornimentoModel;

import java.util.List;

@Repository
public interface RifornimentoRepo extends JpaRepository<RifornimentoModel, Long> 
{
    
    RifornimentoModel findById(long id);
    List<RifornimentoModel> findByIdUserAndIdVeicolo(Long idUser, Long idVeicolo);
    List<RifornimentoModel> findByIdUser(Long idUser);

}
