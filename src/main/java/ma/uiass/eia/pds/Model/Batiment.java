package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "TBatiment")
@Inheritance(strategy = InheritanceType.JOINED)

public class Batiment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBatiment;
    @Column(name="NumBatiment", length=50)
    private String numBatiment;
    @JsonIgnore
    @OneToMany(mappedBy = "batiment", fetch = FetchType.LAZY )
    private List<Etage> etages = new ArrayList<>();

    public int getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
    }

    public String getNumBatiment() {
        return numBatiment;
    }
    public List<Etage> getEtages() {
        return etages;
    }

    public void setNumBatiment(String numBatiment) {
        this.numBatiment = numBatiment;
    }

    public void setEtages(List<Etage> etages) {
        this.etages = etages;
    }

    public Batiment(String numBatiment) {
        this.numBatiment = numBatiment;
    }

    public Batiment(){

    }

    public String toString(){
        return this.numBatiment;
    }
}
