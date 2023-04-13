package ma.uiass.eia.pds.Model;

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
    @JoinColumn(name = "idLivraisonFournisseur", referencedColumnName = "idLivraisonFournisseur")
    private LivraisonFournisseur livraisonFournisseur;

    @OneToOne
    @JoinColumn(name = "idDispoMedical", referencedColumnName = "idDispoMedical")
    private DispoMedical dispoMedical;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LivraisonFournisseur getLivraisaonFournisseur() {
        return livraisonFournisseur;
    }

    public void setLivraisaonFournisseur(LivraisonFournisseur livraisonFournisseur) {
        this.livraisonFournisseur = livraisonFournisseur;
    }

    public DispoMedical getDispoMedical() {
        return dispoMedical;
    }

    public void setDispoMedical(DispoMedical dispoMedical) {
        this.dispoMedical = dispoMedical;
    }

    public int getIdDetailsLivraison() {
        return idDetailsLivraison;
    }

    public void setIdDetailsLivraison(int idDetailsLivraison) {
        this.idDetailsLivraison = idDetailsLivraison;
    }

    public DetailsLivraison(int quantite, LivraisonFournisseur livraisonFournisseur, DispoMedical dispoMedical) {
        this.quantite = quantite;
        this.livraisonFournisseur = livraisonFournisseur;
        this.dispoMedical = dispoMedical;
    }
    public DetailsLivraison(){

    }
}
