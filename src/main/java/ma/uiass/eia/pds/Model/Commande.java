package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name= "TCommande")
public class Commande implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommande;
    @Column(name = "NumCommande", length = 50)
    private String numCommande;
    @Column(name = "Quantite", length = 50)
    private int quantite;
    @Column(name = "DateCommande", length = 50)
    private Date dateCommande;
    @Column(name = "DateLivraison", length = 50)
    private Date dateLivraison;
    @Column
    private Boolean confirmation;

    @ManyToMany
    @JoinTable(name = "detailsCommande", joinColumns = {@JoinColumn(name = "idCommande")}, inverseJoinColumns = {@JoinColumn(name = "idLit")})
    private List<Lit> lits;



    public int getIdReservation() {
        return idCommande;
    }

    public void setIdReservation(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(String numCommande) {
        this.numCommande = numCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }


    public Commande() {

    }

    public Commande(String numCommande, int quantite, Date dateCommande, Date dateLivraison, Boolean confirmation, List<Lit> lits) {
        this.numCommande = numCommande;
        this.quantite = quantite;
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.confirmation = confirmation;
    }
}


