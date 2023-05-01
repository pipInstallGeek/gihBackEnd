package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="DetailDemandeDM")
public class DetailDemandeDM implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int detailDDM_id;
    @Column(name="codeDetailDDM")
    private String code;
    @Column(name="Quantite")
    private int quantite;
    @JoinColumn(name = "idDM")
    @ManyToOne
    private DispositifMedical dispositif;
    @JsonIgnore
    @JoinColumn(name = "DemandeDM_id")
    @ManyToOne
    private DemandeDM demandeDM;

    public DispositifMedical getDispositif() {
        return dispositif;
    }

    public void setDispositif(DispositifMedical dispositif) {
        this.dispositif = dispositif;
    }

    public DemandeDM getDemandeDM() {
        return demandeDM;
    }

    public void setDemandeDM(DemandeDM demandeDM) {
        this.demandeDM = demandeDM;
    }

    public DetailDemandeDM(String code, int quantite, DispositifMedical dispositif) {
        this.code = code;
        this.quantite = quantite;
        this.dispositif = dispositif;

    }

    public DetailDemandeDM() {
    }

    public int getDtailDDM_id() {
        return detailDDM_id;
    }

    public void setDtailDDM_id(int dtailDDM_id) {
        this.detailDDM_id = dtailDDM_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "DetailDemandeDM{" +
                "code='" + code + '\'' +
                ", quantite=" + quantite +
                ", dispositif=" + dispositif +
                '}';
    }
}

