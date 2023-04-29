package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "TDemande")
public class Demande implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemande;
    @Column(name = "numDemande", length = 50)
    private String numDemande;
    @Column(name = "quantite", length = 50)
    private int quantite;
    @Column(name = "dateDemande", length = 50)
    private String dateDemande;
    @Column(name = "dateLivraison")
    private String dateLivraison;

    @Column(name = "typelit", length = 50)
    private String typelit;

    @Column(name = "marque", length = 50)
    private String marque;

    @Column(name = "service", length = 50)
    private String service;
    @Column
    @Enumerated(EnumType.STRING)
    private EtatDemande etat;

    public Demande(String numDemande, int quantite, String dateDemande, String dateLivraison, String typelit, String marque, EtatDemande etat, String service) {
        this.numDemande = numDemande;
        this.quantite = quantite;
        this.dateDemande = dateDemande;
        this.dateLivraison = dateLivraison;
        this.typelit=typelit;
        this.marque=marque;
        this.etat=etat;
        this.service=service;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public String getNumDemande() {
        return numDemande;
    }

    public void setNumDemande(String numDemande) {
        this.numDemande = numDemande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
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

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public EtatDemande getEtat() {
        return etat;
    }

    public void setEtat(EtatDemande etat) {
        this.etat = etat;
    }



    public Demande(){

    }

    @Override
    public String toString() {
        return "Demande{" +
                "numDemande='" + numDemande + '\'' +
                ", quantite=" + quantite +
                ", dateDemande='" + dateDemande + '\'' +
                ", dateLivraison='" + dateLivraison + '\'' +
                ", typelit='" + typelit + '\'' +
                ", marque='" + marque + '\'' +
                ", service='" + service + '\'' +
                ", etat=" + etat +'}';

    }
}
