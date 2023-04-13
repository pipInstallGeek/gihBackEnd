package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="TDemandeL")

public class DemandeL implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemandeL;
    @Column(name="CodeDemandeL", length=50)
    private String codeDemandeL;
    @Column(name="DateDemande", length=50)
    private Date dateDemande;
    @JoinColumn(name = "idService",referencedColumnName = "idService")
    @ManyToOne
    private Service service;

    public DemandeL() {
    }

    public DemandeL(String codeDemandeL, Date dateDemande, Service service, EtatDemandeL etat, List<DetailDemandeL> detailDemande) {
        this.codeDemandeL = codeDemandeL;
        this.dateDemande = dateDemande;
        this.service = service;
        this.etat = etat;
        this.detailDemande = detailDemande;
    }

    @Column
    @Enumerated(EnumType.STRING)
    private EtatDemandeL etat;
    @OneToMany(mappedBy ="demande")
    private List<DetailDemandeL> detailDemande ;

    public int getIdDemandeL() {
        return idDemandeL;
    }

    public void setIdDemandeL(int idDemandeL) {
        this.idDemandeL = idDemandeL;
    }

    public String getCodeDemandeL() {
        return codeDemandeL;
    }

    public void setCodeDemandeL(String codeDemandeL) {
        this.codeDemandeL = codeDemandeL;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public EtatDemandeL getEtat() {
        return etat;
    }

    public void setEtat(EtatDemandeL etat) {
        this.etat = etat;
    }

    public List<DetailDemandeL> getDetailDemande() {
        return detailDemande;
    }

    public void setDetailDemande(List<DetailDemandeL> detailDemande) {
        this.detailDemande = detailDemande;
    }
}
