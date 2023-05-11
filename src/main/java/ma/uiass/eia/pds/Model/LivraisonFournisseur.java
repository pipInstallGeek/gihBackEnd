package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TLivraisonFournisseur")
public class LivraisonFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeLivraisonFournisseur;

    @Column
    private String dateLivraison;

    @ManyToOne
    @JoinColumn(name = "codeFournisseur", referencedColumnName = "codeFournisseur")
    private Fournisseur fournisseur;

    public int getCodeLivraisonFournisseur() {
        return codeLivraisonFournisseur;
    }

    public void setCodeLivraisonFournisseur(int codeLivraisonFournisseur) {
        this.codeLivraisonFournisseur = codeLivraisonFournisseur;
    }

    public String  getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public LivraisonFournisseur(String dateLivraison, Fournisseur fournisseur) {
        this.dateLivraison = dateLivraison;
        this.fournisseur = fournisseur;
    }

    public LivraisonFournisseur() {
    }

    public String toString(){
        return this.fournisseur.toString();
    }
}

