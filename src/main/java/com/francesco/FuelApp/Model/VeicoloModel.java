package com.francesco.FuelApp.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Veicolo")
public class VeicoloModel 
{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = false)
    private String NomeVeicolo;

    @Column (unique = false, nullable = false)
    private Long idUser; 

    public VeicoloModel() {}
    public VeicoloModel(Long id, String NomeVeicolo, Long idUser)
    {
        this.id = id;
        this.NomeVeicolo = NomeVeicolo;
        this.idUser = idUser;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNomeVeicolo()
    {
        return NomeVeicolo;
    }   

    public void setNomeVeicolo(String NomeVeicolo)
    {
        this.NomeVeicolo = NomeVeicolo;
    }

    public Long getIdUser()
    {
        return idUser;
    }

    public void setIdUser(Long idUser)
    {
        this.idUser = idUser;
    }
}
