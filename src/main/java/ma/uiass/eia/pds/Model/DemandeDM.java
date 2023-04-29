package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="DemandeDM")
public class DemandeDM implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int DemandeDM_id;
    @Column(name="codeDemandeDM")
    private String code;
    @Column(name="DateDemande")
    private Date dateDemande;

    @OneToMany(mappedBy = "demandeDM")
    private List<DetailDemandeDM> list ;
    @JoinColumn(name = "idService")
    @ManyToOne
    private Service service;
    @Column
    @Enumerated(EnumType.STRING)
    private EtatDemande etat;

    public EtatDemande getEtat() {
        return etat;
    }

    public void setEtat(EtatDemande etat) {
        this.etat = etat;
    }

    public DemandeDM(String code, Date dateDemande,  Service service, EtatDemande etat) {
        this.code = code;
        this.dateDemande = dateDemande;
        this.service = service;
        this.etat = etat;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public DemandeDM() {
    }

    public int getDemandeDM_id() {
        return DemandeDM_id;
    }

    public void setDemandeDM_id(int demandeDM_id) {
        this.DemandeDM_id = demandeDM_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    @Override
    public String toString() {
        return "DemandeDM{" +
                "demandeDM_id=" + DemandeDM_id +
                ", code='" + code + '\'' +
                ", dateDemande=" + dateDemande +
                ", list=" + list +
                ", service=" + service +
                '}';
    }

    public List<DetailDemandeDM> getList() {
        return list;
    }

    public void setList(List<DetailDemandeDM> list) {
        this.list = list;
    }
}
