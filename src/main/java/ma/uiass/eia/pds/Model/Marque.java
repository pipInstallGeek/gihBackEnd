package ma.uiass.eia.pds.Model;

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

    @OneToMany(mappedBy = "marque")
    private List<Lit> lits=new ArrayList<>();
    public Marque(String code_Marque, String nom_Marque) {
        codeMarque = code_Marque;
        nomMarque = nom_Marque;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int id_M) {
        this.idMarque = id_M;
    }

    public Marque(){
    }

    public String getNomMarque() { return nomMarque; }

    public void setNomMarque(String nomMarque) { this.nomMarque = nomMarque; }

    public String getCodeMarque() { return codeMarque; }

    public void setCodeMarque(String codeMarque) { this.codeMarque = codeMarque; }


}
