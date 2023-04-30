package ma.uiass.eia.pds.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TDispoMedical")
@Data
@NoArgsConstructor
public class DispositifMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDispositifMedical;

    @Column
    private String nameDispositifMedical;


    @OneToMany(mappedBy = "dispositifMedical")
    @JsonIgnore
    private List<DetailsLivraison> detailsLivraison;
    @ManyToOne
    @JoinColumn(name = "idTypeDm", referencedColumnName = "idTypeDM")
    private TypeDM typeDM;
    @JsonIgnore
    @OneToMany(mappedBy = "dispositifMedical")
    private List<StocksDetails> stocksDetails;

    public DispositifMedical(String nameDispositifMedical, TypeDM typeDM){
        setNameDispositifMedical(nameDispositifMedical);
        setTypeDM(typeDM);
    }


    public String toString(){
        return this.getNameDispositifMedical();

    }
}
