package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TDetailsLivraison")
public class DetailsLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeDetailsFournisseur;

    @Column
    private String dateLivraison;

    @OneToMany(mappedBy = "detailsLivraison", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LivraisonFournisseur> livraisonFournisseurs = new ArrayList<>();


    public void addLivraisonFournisseur(LivraisonFournisseur livraisonFournisseur) {
        livraisonFournisseurs.add(livraisonFournisseur);
        livraisonFournisseur.setDetailsLivraison(this);
    }

    public void removeLivraisonFournisseur(LivraisonFournisseur livraisonFournisseur) {
        livraisonFournisseurs.remove(livraisonFournisseur);
        livraisonFournisseur.setDetailsLivraison(null);


    }

    public int getCodeDetailsFournisseur() {
        return codeDetailsFournisseur;
    }

    public void setCodeDetailsFournisseur(int codeDetailsFournisseur) {
        this.codeDetailsFournisseur = codeDetailsFournisseur;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public List<LivraisonFournisseur> getLivraisonFournisseurs() {
        return livraisonFournisseurs;
    }

    public void setLivraisonFournisseurs(List<LivraisonFournisseur> livraisonFournisseurs) {
        this.livraisonFournisseurs = livraisonFournisseurs;
    }

    public DetailsLivraison(String dateLivraison, List<LivraisonFournisseur> livraisonFournisseurs) {
        this.dateLivraison = dateLivraison;
        this.livraisonFournisseurs = livraisonFournisseurs;
    }

    public DetailsLivraison() {
    }
    public String toString(){
        return String.valueOf(codeDetailsFournisseur) + dateLivraison;
    }
}
