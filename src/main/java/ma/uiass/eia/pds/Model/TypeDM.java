package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "TtypeDM")
public class TypeDM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeDM;

    @Column
    private String codeDM;
    @Column
    private String nomType;

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
