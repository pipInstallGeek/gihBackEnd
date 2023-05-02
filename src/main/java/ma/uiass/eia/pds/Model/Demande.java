package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TDemande")
public class Demande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemande;



    @ManyToOne
    @JoinColumn(name = "idService", referencedColumnName = "idService")
    private Service service;

    @Column
    private LocalDate dateDemande;

    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetailsDemande> detailDemande= new ArrayList<>();
    public Demande() {

    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }

    public List<DetailsDemande> getDetailsDemande() {
        return detailDemande;
    }

    public void setDetailsDemande(List<DetailsDemande> detailsDemande) {
        this.detailDemande = detailsDemande;
    }

    public Demande(Service service, List<DetailsDemande> detailsDemande) {
        this.service = service;
        this.dateDemande = LocalDate.now();
        this.detailDemande = detailsDemande;
    }
}
