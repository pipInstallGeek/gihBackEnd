package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TDM")
public class DM implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDM;
    @Column(name="CodeDM", length=50)
    private String codeDM;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemandeL;

    public DM() {
    }

    public DM(String codeDM, int idDemandeL, int stockDM, List<TypeDM> typeDMS) {
        this.codeDM = codeDM;
        this.idDemandeL = idDemandeL;
        this.stockDM = stockDM;
        this.typeDMS = typeDMS;
    }

    public int getIdDM() {
        return idDM;
    }

    public void setIdDM(int idDM) {
        this.idDM = idDM;
    }

    public String getCodeDM() {
        return codeDM;
    }

    public void setCodeDM(String codeDM) {
        this.codeDM = codeDM;
    }

    public int getIdDemandeL() {
        return idDemandeL;
    }

    public void setIdDemandeL(int idDemandeL) {
        this.idDemandeL = idDemandeL;
    }

    public int getStockDM() {
        return stockDM;
    }

    public void setStockDM(int stockDM) {
        this.stockDM = stockDM;
    }

    public List<TypeDM> getTypeDMS() {
        return typeDMS;
    }

    public void setTypeDMS(List<TypeDM> typeDMS) {
        this.typeDMS = typeDMS;
    }

    @Column(name="stockDM", length=50)
    private int stockDM;
    @JsonIgnore
    @OneToMany(mappedBy = "dm", fetch = FetchType.LAZY )
    private List<TypeDM> typeDMS = new ArrayList<>();

}
