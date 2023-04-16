package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TTypeDM")
public class TypeDM implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeDM;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDM", referencedColumnName = "idDM")
    private DescriptionDM dmDescription;

    public TypeDM() {
    }

    public TypeDM(int idTypeDM) {

        this.idTypeDM = idTypeDM;
    }

    @Column(name="CodeTypeDM", length=50)
    private String codeTypeDM;
    @Column(name="NomTypeDM", length=50)
    private String NomTypeDM;

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

    public TypeDM(DescriptionDM dmDescription,  String NomTypeDM) {
        this.dmDescription = dmDescription;
        //this.codeTypeDM = codeTypeDM;
        this.NomTypeDM = NomTypeDM;
    }

    public String getNomTypeDM() {
        return NomTypeDM;
    }

    public DescriptionDM getDm() {
        return dmDescription;
    }

    public void setDm(DescriptionDM dmDescription) {
        this.dmDescription = dmDescription;
    }

    public void setNomTypeDM(String NomTypeDM) {
        this.NomTypeDM = NomTypeDM;
    }
}
