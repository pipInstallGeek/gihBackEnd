package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TTypeDM")
@JsonIgnoreProperties(value={"dms"})

public class TypeDM implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeDM;


    public TypeDM() {
    }
    @Column(name="CodeTypeDM", length=50)
    private String codeTypeDM;
    @Column(name="NomTypeDM", length=50)
    private String NomTypeDM;
    @JsonManagedReference
    @OneToMany(mappedBy = "typeDM")
    private List<DescriptionDM> DMs = new ArrayList<>();
    public int getIdTypeDM() {
        return idTypeDM;
    }
    public void setIdTypeDM(int idTypeDM) {
        this.idTypeDM = idTypeDM;
    }
    public String getCodeTypeDM() {
        return codeTypeDM;
    }
    public void setCodeTypeDM(String codeTypeDM) {
        this.codeTypeDM = codeTypeDM;
    }
    public TypeDM(  String NomTypeDM) {
        this.NomTypeDM = NomTypeDM;
    }

    public List<DescriptionDM> getDMs() {
        return DMs;
    }

    public void setDMs(List<DescriptionDM> DMs) {
        this.DMs = DMs;
    }

    public String getNomTypeDM() {
        return NomTypeDM;
    }

    public void setNomTypeDM(String NomTypeDM) {
        this.NomTypeDM = NomTypeDM;
    }
    public String toString(){
        return this.getNomTypeDM();
    }
}
