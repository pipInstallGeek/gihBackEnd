package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table (name = "TLivraisonFournissseur")
public class LivraisonFournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLivraison;

    @Column
    private String codeLivraison;

    @Column
    @Enumerated(EnumType.STRING)
    private Fournisseur fournisseur;

    @Column
    private LocalDate dateLivraison;

    public LivraisonFournisseur() {

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

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public LivraisonFournisseur(int idLivraison, String codeLivraison, Fournisseur fournisseur, LocalDate dateLivraison) {
        this.idLivraison = idLivraison;
        this.codeLivraison = codeLivraison;
        this.fournisseur = fournisseur;
        this.dateLivraison = dateLivraison;
    }
    public LivraisonFournisseur(String codeLivraison, Fournisseur fournisseur, LocalDate dateLivraison) {
        this.codeLivraison = codeLivraison;
        this.fournisseur = fournisseur;
        this.dateLivraison = dateLivraison;
    }
}
