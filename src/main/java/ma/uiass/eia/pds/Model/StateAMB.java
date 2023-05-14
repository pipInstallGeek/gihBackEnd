package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;



@Entity
@Table(name= "TStateAMB")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StateF.class, name = "stateF"),
        @JsonSubTypes.Type(value = StateNFCD.class, name = "stateNFCD"),
        @JsonSubTypes.Type(value = StateNFLD.class, name = "stateNFLD"),
})
@Data
@NoArgsConstructor
public abstract  class StateAMB implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idState;

    @Column(name="codeState", length=50)
    private String codeState;

    public StateAMB(String nomState, double paraX, double paraY) {
        this.nomState = nomState;
        this.paraX = paraX;
        this.paraY = paraY;
    }

    @Column(name="nomState", length=50)
    private String nomState;
    @Column(name="paraA", length=50)
    private static double paraA;
    @Column(name="paraB", length=50)
    private static double paraB;
    @Column(name="paraX", length=50)
    private  double paraX;
    @Column(name="paraY", length=50)
    private  double paraY;
    public StateAMB(String nomState) {
        this.nomState = nomState;
    }
    @OneToOne(mappedBy = "state")
    private Ambulance ambulance;



    public String toString(){
        return this.nomState;
    }
}
