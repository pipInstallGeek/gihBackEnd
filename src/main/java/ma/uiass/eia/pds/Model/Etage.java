package ma.uiass.eia.pds.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name= "TEtage")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Etage {
    public String getCodeEtage() {
        return codeEtage;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtage;

    @JsonProperty("codeEtage")
    @Column(name="codeEtage", length=50)
    private String codeEtage;
    @JsonIgnore
    @OneToMany(mappedBy="etage")
    private List<Service> services=new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBatiment", referencedColumnName = "idBatiment")
    private Batiment batiment;

    public void setCodeEtage(String codeEtage) {
        this.codeEtage = codeEtage;
    }

    public Etage(String codeEtage, Batiment batiment) {
        this.codeEtage = batiment.getCodeBatiment()+codeEtage;
        this.batiment = batiment;
    }

    public Etage(){

    }
    public String toString(){
        return this.codeEtage;
    }

}