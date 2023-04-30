package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="DetailDemande")
public class DetailDemande  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IdDetail")
    private int detail_id;

    @Column(name="codeDetail")
    private String code;

    @JoinColumn(name = "idDemande")
    @ManyToOne
    private Demande demande;

    @Column(name="quantite")
    private int quantite;

    @Column(name="DM")
    private String DM;


    public DetailDemande( String DM, int quantite) {
        this.quantite = quantite;
        this.DM=DM;

    }
    public DetailDemande() {
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDM() {
        return DM;
    }

    public void setDM(String DM) {
        this.DM = DM;
    }

    @Override
    public String toString() {
        return "DetailDemande{" +
                "code='" + code + '\'' +
                ", quantite=" + quantite +
                ", DM='" + DM + '\'' +
                '}';
    }
}