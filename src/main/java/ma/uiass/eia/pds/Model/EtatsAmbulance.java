package ma.uiass.eia.pds.Model;

import javax.persistence.*;

@Entity(name = "t_etat_ambulance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class EtatsAmbulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etat")
    private int id;

    @Column(name = "nom_etat")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StateName getStateName() {
        return stateName;
    }

    public void setStateName(StateName stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "EtatAmbulance{" +
                "id=" + id +
                ", stateName=" + stateName +
                '}';
    }
}
