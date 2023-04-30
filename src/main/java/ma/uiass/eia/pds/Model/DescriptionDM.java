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
public class DescriptionDM implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDM;
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




    public DescriptionDM(String nomDM, int quantité, TypeDM typeDM, Espace espace) {

        this.nomDM = nomDM;
        this.quantité = quantité;
        this.typeDM = typeDM;
        this.espace = espace;
    }

    public DescriptionDM(String codeDM, String nomDM, int quantité, TypeDM typeDM) {
        this.codeDM = codeDM;
        this.nomDM = nomDM;
        this.quantité = quantité;
        this.typeDM = typeDM;
    }



    public DescriptionDM(String nomDM, int quantité, TypeDM t) {
      this.typeDM=t;
        this.nomDM = nomDM;
        this.quantité = quantité;
    }


    public String toString(){
        return this.getNomDM();
    }
}
