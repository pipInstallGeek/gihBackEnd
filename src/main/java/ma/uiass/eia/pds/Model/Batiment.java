package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "TBatiment")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Batiment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBatiment;
    @Column(name="codeBatiment", length=50)
    private String codeBatiment;
    @JsonIgnore
    @OneToMany(mappedBy = "batiment", fetch = FetchType.LAZY )
    private List<Etage> etages = new ArrayList<>();



    public Batiment(String codeBatiment) {
        this.codeBatiment = codeBatiment;
    }


    public String toString(){
        return this.codeBatiment;
    }
}