package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEtatAmbulance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
