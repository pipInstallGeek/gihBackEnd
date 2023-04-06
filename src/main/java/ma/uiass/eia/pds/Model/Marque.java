package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "TMarque")
public class Marque implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarque;
    @Column(length =40,name="codeMarque")
    private String codeMarque;
    @Column(length = 40,name="nomMarque")
    private String nomMarque;
    @JsonIgnore
    @OneToMany(mappedBy = "marque")
    private List<Lit> lits=new ArrayList<>();

    public List<Lit> getLits() {
        return lits;
    }

    public void setLits(List<Lit> lits) {
        this.lits = lits;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int id_M) {
        this.idMarque = id_M;
    }

    public String getNomMarque() { return nomMarque; }

    public void setNomMarque(String nomMarque) { this.nomMarque = nomMarque; }

    public String getCodeMarque() { return codeMarque; }

    public void setCodeMarque(String codeMarque) { this.codeMarque = codeMarque; }

    public Marque(String code_Marque, String nom_Marque) {
        this.codeMarque = code_Marque;
        this.nomMarque = nom_Marque;
    }

    public Marque(){
    }

    @Override
    public String toString() {
        return nomMarque;
    }
}
