package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name= "TDemande")
@Data
@NoArgsConstructor
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
