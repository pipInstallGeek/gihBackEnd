package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "TLivraisonFournisseur")
public class Livraison implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLivraison;
    @OneToMany(mappedBy = "livraison")
    private List<DetailLivraison> detailLivraisons;
    @Column(name="codeLivraison", length=50)
    private String codeLivraison;
    @Column(name="dateLivraison", length=50)
    private String dateLivraison;
    @Column(name="fournisseur", length=50)
    private String fournisseur;


    public Livraison() {
    }

    public Livraison(List<DetailLivraison> detailLivraisons, String codeLivraison, String dateLivraison, String fournisseur) {
        this.detailLivraisons = detailLivraisons;
        this.codeLivraison = codeLivraison;
        this.dateLivraison = dateLivraison;
        this.fournisseur = fournisseur;
    }

    public List<DetailLivraison> getDetailLivraisons() {
        return detailLivraisons;
    }

    public void setDetailLivraisons(List<DetailLivraison> detailLivraisons) {
        this.detailLivraisons = detailLivraisons;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }

    public String getCodeLivraison() {
        return codeLivraison;
    }

    public void setCodeLivraison(String codeLivraison) {
        this.codeLivraison = codeLivraison;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }





}
