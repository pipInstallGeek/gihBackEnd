package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "TEquipement")
public class Equipement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipement;
    @Column
    private String codeEquipement;
    @Column
    private String nomEquipement;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idLit", referencedColumnName = "idLit")
    private Lit lit;
    public String getCodeEquipement() {
        return codeEquipement;
    }

    public void setCodeEquipement(String codeEquipement) {
        this.codeEquipement = codeEquipement;
    }

    public String getNomEquipement() {
        return nomEquipement;
    }

    public void setNomEquipement(String nomEquipement) {
        this.nomEquipement = nomEquipement;
    }

    public Equipement(String codeEquipement, String nomEquipement) {
        this.codeEquipement = codeEquipement;
        this.nomEquipement = nomEquipement;
    }
    public Equipement(){};
}
