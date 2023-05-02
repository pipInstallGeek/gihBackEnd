package ma.uiass.eia.pds.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TtypeDM")
public class TypeDM implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeDM;

    @Column
    private String codeDM;
    @Column
    private String nomType;

    @OneToMany(mappedBy = "typeDM")
    @JsonIgnore
    private List<DispositifMedical> dispositifMedicals;

    public List<DispositifMedical> getDispositifMedicals() {
        return dispositifMedicals;
    }

    public void setDispositifMedicals(List<DispositifMedical> dispositifMedicals) {
        this.dispositifMedicals = dispositifMedicals;
    }

    public int getIdTypeDM() {
        return idTypeDM;
    }

    public void setIdTypeDM(int codeTypeDm) {
        this.idTypeDM = codeTypeDm;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public String getCodeDM() {
        return codeDM;
    }

    public void setCodeDM(String codeDM) {
        this.codeDM = codeDM;
    }

    public TypeDM(String codeDM,String nomType){
        setCodeDM(codeDM);
        setNomType(nomType);
    }

    public TypeDM(){

    }

    public String toString(){
        return this.getNomType();
    }
}
