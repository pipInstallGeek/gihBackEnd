package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "TDetailLivraison")

public class DetailLivraison implements Serializable {
    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDL;
    @Column(name="codeDL", length=50)
    private String codeDL;
    @Column(name="quantité", length=50)
    private String quantité;
    @ManyToOne
    @JoinColumn(name = "idLivraison")
    private Livraison livraison;

    public DetailLivraison() {
    }

    public DetailLivraison(String codeDL, String quantité) {
        this.codeDL = codeDL;
        this.quantité = quantité;
    }

    public String getQuantité() {
        return quantité;
    }

    public void setQuantité(String quantité) {
        this.quantité = quantité;
    }

    public int getIdDL() {
        return idDL;
    }

    public void setIdDL(int idDL) {
        this.idDL = idDL;
    }

    public String getCodeDL() {
        return codeDL;
    }

    public void setCodeDL(String codeDL) {
        this.codeDL = codeDL;
    }
}
