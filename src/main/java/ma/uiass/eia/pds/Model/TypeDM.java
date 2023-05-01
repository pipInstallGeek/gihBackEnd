package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TtypeDM")
@Data
@NoArgsConstructor
public class TypeDM implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeDM;

    @Column
    private String codeTypeDM;
    @Column
    private String nomType;

    @OneToMany(mappedBy = "typeDM")
    @JsonIgnore
    private List<DispositifMedical> DMs = new ArrayList<>();

    public TypeDM( String nomType) {
        setNomType(nomType);
    }
}
