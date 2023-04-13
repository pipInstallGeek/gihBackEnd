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
    @Column(name="codeBatiment", length=50)
    private String codeBatiment;
    @JsonIgnore
    @OneToMany(mappedBy = "batiment", fetch = FetchType.LAZY )
    private List<Etage> etages = new ArrayList<>();

    public int getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
    }

    public String getCodeBatiment() {
        return codeBatiment;
    }
    public List<Etage> getEtages() {
        return etages;
    }

    public void setCodeBatiment(String numBatiment) {
        this.codeBatiment = numBatiment;
    }

    public void setEtages(List<Etage> etages) {
        this.etages = etages;
    }

    public Batiment(String codeBatiment) {
        this.codeBatiment = codeBatiment;
    }

    public Batiment(){

    }


    public String toString(){
        return this.codeBatiment;
    }
}
