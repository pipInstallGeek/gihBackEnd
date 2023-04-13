package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "TtypeDM")
public class TypeDM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeTypeDm;

    @Column
    private String nomType;

    public int getCodeTypeDm() {
        return codeTypeDm;
    }

    public void setCodeTypeDm(int codeTypeDm) {
        this.codeTypeDm = codeTypeDm;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public TypeDM(String nomType){
        setNomType(nomType);
    }

    public String toString(){
        return this.getNomType();
    }
}
