package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name="nomTypeDM", length=50)
    private String nomTypeDM;
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
    public TypeDM(  String nomTypeDM) {
        this.nomTypeDM = nomTypeDM;
    }

    public List<DescriptionDM> getDMs() {
        return DMs;
    }

    public void setDMs(List<DescriptionDM> DMs) {
        this.DMs = DMs;
    }

    public String getNomTypeDM() {
        return nomTypeDM;
    }

    public void setNomTypeDM(String nomTypeDM) {
        this.nomTypeDM =nomTypeDM;
    }
    public String toString(){
        return this.getNomTypeDM();
    }
}
