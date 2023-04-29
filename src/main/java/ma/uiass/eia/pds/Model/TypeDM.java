package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TtypeDM")
@Data

public class TypeDM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeDM;

    @Column
    private String codeTypeDM;
    @Column
    private String nomType;

    @OneToMany(mappedBy = "typeDM")
    @JsonIgnore
    private List<DispositifMedical> dispositifMedicals;

    public TypeDM(String codeDM, String nomType) {
        setCodeDM(codeDM);
        setNomType(nomType);
    }
}
