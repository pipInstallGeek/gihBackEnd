package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEtatAmbulance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = F.class, name = "f"),
        @JsonSubTypes.Type(value = NFCD.class, name = "nfcd"),
        @JsonSubTypes.Type(value = NFLD.class, name = "nfld"),
})
public abstract class EtatsAmbulance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int codeEtat;

    @Column
    @Enumerated(EnumType.STRING)
    private StateName stateName;
    @Transient
    private static double A;
    @Transient
    private static double B;
    private double x;
    private double y;

    @OneToOne
    @JoinColumn(name = "id_ambulance")
    private Ambulance ambulance;

    public EtatsAmbulance() {
    }

    public EtatsAmbulance(StateName stateName) {
        this.stateName = stateName;
    }

    public int getCodeEtat() {
        return codeEtat;
    }

    public void setCodeEtat(int codeEtat) {
        this.codeEtat = codeEtat;
    }

    public StateName getStateName() {
        return stateName;
    }

    public void setStateName(StateName stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {return "EtatAmbulance{" + "id=" + codeEtat + ", stateName=" + stateName + '}';}
}
