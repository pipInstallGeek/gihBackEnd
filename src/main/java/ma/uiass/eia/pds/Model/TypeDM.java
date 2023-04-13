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
    private DM dm;

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

    public TypeDM(DM dm, String codeTypeDM, String NomTypeDM) {
        this.dm = dm;
        this.codeTypeDM = codeTypeDM;
        this.NomTypeDM = NomTypeDM;
    }

    public String getNomTypeDM() {
        return NomTypeDM;
    }

    public DM getDm() {
        return dm;
    }

    public void setDm(DM dm) {
        this.dm = dm;
    }

    public void setNomTypeDM(String NomTypeDM) {
        this.NomTypeDM = NomTypeDM;
    }
}
