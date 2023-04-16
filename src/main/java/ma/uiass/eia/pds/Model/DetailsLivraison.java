package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TDetailsLivraison")
public class DetailsLivraison implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetails;

    @Column
    private int quantité;

    @ManyToOne
    @JoinColumn(name = "codeLivraison", referencedColumnName = "codeLivraison")
    private LivraisonFournisseur livraisonFournisseur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDispoMedical")
    private DispoMedical dispoMedical;

    public DetailsLivraison() {

    }

    public int getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(int idDetails) {
        this.idDetails = idDetails;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public LivraisonFournisseur getLivraisonFournisseur() {
        return livraisonFournisseur;
    }

    public void setLivraisonFournisseur(LivraisonFournisseur livraisonFournisseur) {
        this.livraisonFournisseur = livraisonFournisseur;
    }

    public DetailsLivraison(int idDetails, int quantité, LivraisonFournisseur livraisonFournisseur) {
        this.idDetails = idDetails;
        this.quantité = quantité;
        this.livraisonFournisseur = livraisonFournisseur;
    }
    public DetailsLivraison(LivraisonFournisseur livraisonFournisseur,int quantite){
        this.setQuantité(quantite);
        this.setLivraisonFournisseur(livraisonFournisseur);
    }

}
