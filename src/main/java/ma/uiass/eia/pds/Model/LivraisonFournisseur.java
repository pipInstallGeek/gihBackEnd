package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "livraisonFournisseur")
public class LivraisonFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLivraisonFournisseur;

    @Column
    private String codeLivraisonFournisseur;

    @Column
    private String fournisseur;

    @JsonIgnore
    @OneToMany(mappedBy = "livraisaonFournisseur")
    private List<DetailsLivraison> detailsLivraisons;

    public int getIdLivraisonFournisseur() {
        return idLivraisonFournisseur;
    }

    public void setIdLivraisonFournisseur(int idLivraisonFournisseur) {
        this.idLivraisonFournisseur = idLivraisonFournisseur;
    }

    public String getCodeLivraisonFournisseur() {
        return codeLivraisonFournisseur;
    }

    public void setCodeLivraisonFournisseur(String codeLivraisonFournisseur) {
        this.codeLivraisonFournisseur = codeLivraisonFournisseur;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<DetailsLivraison> getDetailsLivraisons() {
        return detailsLivraisons;
    }

    public void setDetailsLivraisons(List<DetailsLivraison> detailsLivraisons) {
        this.detailsLivraisons = detailsLivraisons;
    }

    public LivraisonFournisseur(String codeLivraisonFournisseur, String fournisseur, List<DetailsLivraison> detailsLivraisons) {
        this.codeLivraisonFournisseur = codeLivraisonFournisseur;
        this.fournisseur = fournisseur;
        this.detailsLivraisons = detailsLivraisons;
    }
    public LivraisonFournisseur(){

    }
}
