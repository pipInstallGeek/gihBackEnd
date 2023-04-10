package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "TCommande")
public class Commande implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommande;
    @Column(name = "numCommande", length = 50)
    private String numCommande;
    @Column(name = "quantite", length = 50)
    private int quantite;
    @Column(name = "dateCommande", length = 50)
    private String dateCommande;
    @Column(name = "dateLivraison")
    private String dateLivraison;
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTypelit")
    private TypeLit typelit;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMarque")
    private Marque marque;*/
    @Column(name = "sercvice")
    private String service;
    @Column(name = "typelit", length = 50)
    private String typelit;

    @Column(name = "marque", length = 50)
    private String marque;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatCommande etat;

    public Commande(String numCommande, int quantite, String dateCommande, String dateLivraison, String typelit, String marque, EtatCommande etat, String service) {
        this.numCommande = numCommande;
        this.quantite = quantite;
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.typelit=typelit;
        this.marque=marque;
        this.etat=etat;
        this.service=service;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

   // public String getNomMarque() {return this.marque.getNomMarque();}
    //public String getNomTypeLit() {return this.typelit.getNomTypeLit();}


    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
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

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getTypelit() {
        return typelit;
    }

    public void setTypelit(String typelit) {
        this.typelit = typelit;
    }

    public String getMarque() {return marque;}

    public void setMarque(String marque) {this.marque = marque;}

    public Commande(){

    }

    @Override
    public String toString() {
        return "Commande{" +
                "numCommande='" + numCommande + '\'' +
                ", quantite=" + quantite +
                ", dateCommande='" + dateCommande + '\'' +
                ", dateLivraison='" + dateLivraison + '\'' +
                ", typelit=" + typelit +
                ", marque=" + marque +
                ", etat=" + etat +
                '}';
    }
}


