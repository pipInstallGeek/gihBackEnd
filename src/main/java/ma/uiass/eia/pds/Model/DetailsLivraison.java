package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

@Entity
@Table(name="TDetailsLivraison")
public class DetailsLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeDetailsFournisseur;

    @ManyToOne
    @JoinColumn(name = "idDispoMedical", referencedColumnName = "idDispoMedical")
    private DispoMedical dispoMedical;

    @ManyToOne
    @JoinColumn(name = "codeLivraisonFournisseur", referencedColumnName = "codeLivraisonFournisseur")
    private LivraisonFournisseur livraisonFournisseur;

    @Column
    private int quantiteDemande;

    public int getQuantiteDemande() {
        return quantiteDemande;
    }

    public void setQuantiteDemande(int quantiteDemande) {
        this.quantiteDemande = quantiteDemande;
    }

    public int getCodeDetailsFournisseur() {
        return codeDetailsFournisseur;
    }

    public void setCodeDetailsFournisseur(int codeDetailsFournisseur) {
        this.codeDetailsFournisseur = codeDetailsFournisseur;
    }

    public DispoMedical getDispoMedical() {
        return dispoMedical;
    }

    public void setDispoMedical(DispoMedical dispoMedical) {
        this.dispoMedical = dispoMedical;
    }

    public LivraisonFournisseur getLivraisonFournisseur() {
        return livraisonFournisseur;
    }

    public void setLivraisonFournisseur(LivraisonFournisseur livraisonFournisseur) {
        this.livraisonFournisseur = livraisonFournisseur;
    }

    public DetailsLivraison(DispoMedical dispoMedical, LivraisonFournisseur livraisonFournisseur,int quantiteDemande) {
        this.dispoMedical = dispoMedical;
        this.livraisonFournisseur = livraisonFournisseur;
        this.quantiteDemande=quantiteDemande;
    }

    public DetailsLivraison() {
    }
    public String toString(){
        return this.dispoMedical.toString() + this.livraisonFournisseur.toString();
    }
}
