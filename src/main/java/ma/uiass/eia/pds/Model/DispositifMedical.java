package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TDM")
@Data
@NoArgsConstructor
public class DispositifMedical implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDispositifMedical;
    @Column(name="CodeDM", length=50)
    private String codeDM;

    @Column(name="NomDM", length=50)
    private String nomDM;

    @Column(name="Quantité", length=50)
    private int quantité;

    @JsonIgnore
    @OneToMany(mappedBy = "dmDescription", fetch = FetchType.LAZY )
    private List<ExemplaireDM> exemplaires = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypeDM", referencedColumnName = "idTypeDM")
    private TypeDM typeDM;

    @ManyToOne
    @JoinColumn(name = "idEspace", referencedColumnName = "idEspace")
    private Espace espace;

    @JsonIgnore
    @OneToMany(mappedBy = "dispositifMedical")
    private List<StocksDetails> stocksDetails;

    @OneToMany(mappedBy = "dispositifMedical")
    @JsonIgnore
    private List<DetailsLivraison> detailsLivraison;

    public DispositifMedical(String nomDM, int quantité, TypeDM typeDM, Espace espace) {

        this.nomDM = nomDM;
        this.quantité = quantité;
        this.typeDM = typeDM;
        this.espace = espace;
    }

    public DispositifMedical(String codeDM, String nomDM, int quantité, TypeDM typeDM) {
        this.codeDM = codeDM;
        this.nomDM = nomDM;
        this.quantité = quantité;
        this.typeDM = typeDM;
    }



    public DispositifMedical(String nomDM, int quantité, TypeDM t) {
      this.typeDM=t;
      this.nomDM = nomDM;
      this.quantité = quantité;
    }


    public String toString(){
        return this.getNomDM();
    }
}
