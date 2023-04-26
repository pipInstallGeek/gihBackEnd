package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class DetailsLivraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailsLivraison;

    @Column
    private int quantite;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idLivraisonFournisseur", referencedColumnName = "idLivraisonFournisseur")
    private LivraisonFournisseur livraisonFournisseur;

    @ManyToOne
    @JoinColumn(name = "idDispositifMedical", referencedColumnName = "idDispositifMedical")
    private DispositifMedical dispositifMedical;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public DispositifMedical getDispoMedical() {
        return dispositifMedical;
    }

    public void setDispoMedical(DispositifMedical dispositifMedical) {
        this.dispositifMedical = dispositifMedical;
    }

    public int getIdDetailsLivraison() {
        return idDetailsLivraison;
    }

    public void setIdDetailsLivraison(int idDetailsLivraison) {
        this.idDetailsLivraison = idDetailsLivraison;
    }

    public LivraisonFournisseur getLivraisonFournisseur() {
        return livraisonFournisseur;
    }

    public void setLivraisonFournisseur(LivraisonFournisseur livraisonFournisseur) {
        this.livraisonFournisseur = livraisonFournisseur;
    }

    public DispositifMedical getDispositifMedical() {
        return dispositifMedical;
    }

    public void setDispositifMedical(DispositifMedical dispositifMedical) {
        this.dispositifMedical = dispositifMedical;
    }

    public DetailsLivraison(int quantite, LivraisonFournisseur livraisonFournisseur, DispositifMedical dispositifMedical) {
        this.quantite = quantite;
        this.livraisonFournisseur = livraisonFournisseur;
        this.dispositifMedical = dispositifMedical;
    }
    public DetailsLivraison(){

    }
}
