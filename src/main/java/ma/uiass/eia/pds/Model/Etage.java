package ma.uiass.eia.pds.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "TEtage")

public class Etage {
    public String getNumEtage() {
        return NumEtage;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtage;

    @Column(name="NumEtage", length=50)
    private String NumEtage;
    @JsonIgnore
    @OneToMany(mappedBy="etage")
    private List<Service> services=new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBatiment", referencedColumnName = "idBatiment")
    private Batiment batiment;

    public void setNumEtage(String numEtage) {
        NumEtage = numEtage;
    }

    public Etage(String numEtage, Batiment batiment) {
        NumEtage = numEtage;
        this.batiment = batiment;
    }

    public Etage(){

    }
    public String toString(){
        return this.NumEtage;
    }

}
