package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "TDetailDemandeLit")
@Data
@NoArgsConstructor
public class DetailDemandeLit implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int detailDlit_id;

    @Column(name="codeDetailDlit")
    private String code;

    @Column(name="Quantite")
    private int quantite;

    @Column(name = "typelit", length = 50)
    private String typelit;

    @Column(name = "marque", length = 50)
    private String marque;

    @JsonIgnore
    @JoinColumn(name = "Demandelit_id")
    @ManyToOne
    private DemandeLit demandelit;

    public DetailDemandeLit(String code, int quantite, String typelit, String marque) {
        this.code = code;
        this.quantite = quantite;
        this.typelit = typelit;
        this.marque = marque;
    }

    public int getDetailDlit_id() {
        return detailDlit_id;
    }

    public void setDetailDlit_id(int detailDlit_id) {
        this.detailDlit_id = detailDlit_id;
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

    public DemandeLit getDemandelit() {
        return demandelit;
    }

    public void setDemandelit(DemandeLit demandelit) {
        this.demandelit = demandelit;
    }

    @Override
    public String toString() {
        return "DetailDemandeLit{" +
                ", code='" + code + '\'' +
                ", quantite=" + quantite +
                ", typelit='" + typelit + '\'' +
                ", marque='" + marque + '\'' +
                '}';
    }
}
