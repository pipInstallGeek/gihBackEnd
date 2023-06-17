package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "TDemandelit")
@Data
@NoArgsConstructor
public class DemandeLit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Demandelit_id;

    @Column(name = "codeDemandelit")
    private String code;

    @Column(name = "DateDemande")
    private Date dateDemande;

    @OneToMany(mappedBy = "demandelit")
    private List<DetailDemandeLit> list;

    @JoinColumn(name = "idService")
    @ManyToOne
    private Service service;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatDemande etat;

    public DemandeLit(String code, Date dateDemande, Service service, EtatDemande etat) {
        this.code = code;
        this.dateDemande = dateDemande;
        this.service = service;
        this.etat = etat;
    }

    public int getDemandelit_id() {
        return Demandelit_id;
    }

    public void setDemandelit_id(int demandelit_id) {
        Demandelit_id = demandelit_id;
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

    public List<DetailDemandeLit> getList() {
        return list;
    }

    public void setList(List<DetailDemandeLit> list) {
        this.list = list;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public EtatDemande getEtat() {
        return etat;
    }

    public void setEtat(EtatDemande etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "DemandeLit{" +
                ", code='" + code + '\'' +
                ", dateDemande=" + dateDemande +
                ", service=" + service +
                ", etat=" + etat +
                '}';
    }
}