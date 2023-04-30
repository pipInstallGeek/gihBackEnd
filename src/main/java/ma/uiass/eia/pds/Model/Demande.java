package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "TDemande")
public class Demande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemande;
    @Column(name = "numDemande", length = 50)
    private String numDemande;
    @Column(name = "dateDemande", length = 50)
    private String dateDemande;
    @OneToMany(mappedBy ="demande")
    private List<DetailDemande> detailDemande ;
    @Column(name = "service")
    private String service;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatDemande etat;

    public Demande( String dateDemande, EtatDemande etat, String service) {
        this.dateDemande = dateDemande;
        this.etat=etat;
        this.service=service;
        this.detailDemande=detailDemande;
    }

    public Demande() {
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
    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
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

    public List<DetailDemande> getDetailDemande() {
        return detailDemande;
    }

    public void setDetailDemande(List<DetailDemande> detailDemande) {
        this.detailDemande = detailDemande;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "numDemande='" + numDemande + '\'' +
                ", dateDemande='" + dateDemande + '\'' +
                ", detailDemande=" + detailDemande +
                ", service='" + service + '\'' +
                ", etat=" + etat +
                '}';
    }
}
