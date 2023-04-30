package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name= "TEquipement")
@Data
@NoArgsConstructor
public class Equipement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipement;
    @Column
    private String codeEquipement;
    @Column
    private String nomEquipement;
    @ManyToOne
    @JoinColumn(name = "idLit", referencedColumnName = "idLit")
    private Lit lit;


    public Equipement(String codeEquipement, String nomEquipement) {
        this.codeEquipement = codeEquipement;
        this.nomEquipement = nomEquipement;
    }

}