package com.francesco.FuelApp.DTO;

public class NewRifornimentoReq 
{

    private String dataRifornimento;

    private Double prezzoRifornimento;

    private Double LitriRifornimento;

    private Double prezzoAlLitro;

    private Long idVeicolo;

    public NewRifornimentoReq() {}
    public NewRifornimentoReq(String dataRifornimento, Double prezzoRifornimento, Double LitriRifornimento, Double prezzoAlLitro, Long idVeicolo)
    {
        this.dataRifornimento = dataRifornimento;
        this.prezzoRifornimento = prezzoRifornimento;
        this.LitriRifornimento = LitriRifornimento;
        this.prezzoAlLitro = prezzoAlLitro;
        this.idVeicolo = idVeicolo;
    }

    public String getDataRifornimento()
    {
        return dataRifornimento;
    }

    public void setDataRifornimento(String dataRifornimento)
    {
        this.dataRifornimento = dataRifornimento;
    }

    public Double getPrezzoRifornimento()
    {
        return prezzoRifornimento;
    }

    public void setPrezzoRifornimento(Double prezzoRifornimento)
    {
        this.prezzoRifornimento = prezzoRifornimento;
    }

    public Double getLitriRifornimento()
    {
        return LitriRifornimento;
    }

    public void setLitriRifornimento(Double LitriRifornimento)
    {
        this.LitriRifornimento = LitriRifornimento;
    }

    public Double getPrezzoAlLitro()
    {
        return prezzoAlLitro;
    }

    public void setPrezzoAlLitro(Double prezzoAlLitro)
    {
        this.prezzoAlLitro = prezzoAlLitro;
    }

    public Long getIdVeicolo()
    {
        return idVeicolo;
    }

    public void setIdVeicolo(Long idVeicolo)
    {
        this.idVeicolo = idVeicolo;
    }
}
