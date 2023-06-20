package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TLivraisonFournisseur")
public class LivraisonFournisseur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeLivraisonFournisseur;

    @Column
    private int quantiteDemande;

    @ManyToOne
    @JoinColumn(name = "idDispoMedical",referencedColumnName = "idDispoMedical")
    private DispoMedical dispoMedical;

    @ManyToOne
    @JoinColumn(name = "codeFournisseur",referencedColumnName = "codeFournisseur")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "codeDetailsFournisseur",referencedColumnName = "codeDetailsFournisseur")
    private DetailsLivraison detailsLivraison;

    public int getCodeLivraisonFournisseur() {
        return codeLivraisonFournisseur;
    }

    public void setCodeLivraisonFournisseur(int codeLivraisonFournisseur) {
        this.codeLivraisonFournisseur = codeLivraisonFournisseur;
    }

    public int getQuantiteDemande() {
        return quantiteDemande;
    }

    public void setQuantiteDemande(int quantiteDemande) {
        this.quantiteDemande = quantiteDemande;
    }

    public DispoMedical getDispoMedical() {
        return dispoMedical;
    }

    public void setDispoMedical(DispoMedical dispoMedical) {
        this.dispoMedical = dispoMedical;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public DetailsLivraison getDetailsLivraison() {
        return detailsLivraison;
    }

    public void setDetailsLivraison(DetailsLivraison detailsLivraison) {
        this.detailsLivraison = detailsLivraison;
    }

    public LivraisonFournisseur(int quantiteDemande, DispoMedical dispoMedical, Fournisseur fournisseur) {
        this.quantiteDemande = quantiteDemande;
        this.dispoMedical = dispoMedical;
        this.fournisseur = fournisseur;
    }

    public LivraisonFournisseur() {
    }
    public String toString(){
        return dispoMedical.toString() + " " + String.valueOf(quantiteDemande);
    }
}

