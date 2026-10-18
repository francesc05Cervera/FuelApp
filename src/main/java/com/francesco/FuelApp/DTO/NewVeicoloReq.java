package com.francesco.FuelApp.DTO;

public class NewVeicoloReq 
{
    private String NomeVeicolo;

    public NewVeicoloReq() {}
    public NewVeicoloReq(String NomeVeicolo)
    {
        this.NomeVeicolo = NomeVeicolo;
    }

    public String getNomeVeicolo()
    {
        return NomeVeicolo;
    }

    public void setNomeVeicolo(String NomeVeicolo)
    {
        this.NomeVeicolo = NomeVeicolo;
    }
    
}
