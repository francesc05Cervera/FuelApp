package com.francesco.FuelApp.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Rifornimento")
public class RifornimentoModel 
{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = false, nullable = false)
    private String dataRifornimento;

    @Column (unique = false, nullable = false)
    private Double prezzoRifornimento;

    @Column (unique = false, nullable = false)
    private Double LitriRifornimento;

    @Column (unique = false, nullable = false)
    private Double prezzoAlLitro;

    @Column (unique = false, nullable = false)
    private Long idVeicolo;

    @Column (unique = false, nullable = false)
    private Long idUser;

    public RifornimentoModel() {}
    public RifornimentoModel(Long id, String dataRifornimento, Double prezzoRifornimento, Double LitriRifornimento, Double prezzoAlLitro, Long idVeicolo, Long idUser)
    {
        this.id = id;
        this.dataRifornimento = dataRifornimento;
        this.prezzoRifornimento = prezzoRifornimento;
        this.LitriRifornimento = LitriRifornimento;
        this.prezzoAlLitro = prezzoAlLitro;
        this.idVeicolo = idVeicolo;
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

    public void setLitriRifornimento(Double litriRifornimento)
    {
        this.LitriRifornimento = litriRifornimento;
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

    public Long getIdUser()
    {
        return idUser;
    }

    public void setIdUser(Long idUser)
    {
        this.idUser = idUser;
    }
}
