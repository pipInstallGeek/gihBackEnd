package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TDetailsDemande")
public class DetailsDemande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailsDemande;

    @Column
    private int quantité;

    @ManyToOne
    @JoinColumn(name = "idDispoMedical", referencedColumnName = "idDispoMedical")
    private DispoMedical dispoMedical;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idDemande", referencedColumnName = "idDemande")
    private Demande demande;



    public DetailsDemande() {

    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public int getIdDetailsDemande() {
        return idDetailsDemande;
    }

    public void setIdDetailsDemande(int idDetailsDemande) {
        this.idDetailsDemande = idDetailsDemande;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public DispoMedical getDispoMedical() {
        return dispoMedical;
    }

    public void setDispoMedical(DispoMedical dispoMedical) {
        this.dispoMedical = dispoMedical;
    }

    public DetailsDemande(int quantité, DispoMedical dispoMedical, Demande demande) {
        this.quantité = quantité;
        this.dispoMedical = dispoMedical;
        this.demande= demande;
    }
}
