package ma.uiass.eia.pds.Model;



import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TRevision")
public class Revision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_revision")
    private int id;

    @Column(name = "date_revision")
    private String date_revision;

    @Column(name = "description_revision")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_ambulance")
    private Ambulance ambulance;


    @Column(name = "kilometrage_actuel")
    private String kilometrageActuel;

    public Revision() {
    }

    public Revision(String date_revision, Ambulance ambulance) {
        this.date_revision = date_revision;
        this.ambulance = ambulance;

    }

    public Revision(String date_revision, String description, Ambulance ambulance) {
        this.date_revision = date_revision;
        this.description = description;
        this.ambulance = ambulance;

    }

    public Revision(String date_revision, String description, Ambulance ambulance, String kilometrageActuel) {
        this.date_revision = date_revision;
        this.description = description;
        this.ambulance = ambulance;
        this.kilometrageActuel = kilometrageActuel;
    }

    public String getKilometrageActuel() {
        return kilometrageActuel;
    }

    public void setKilometrageActuel(String kilometrageActuel) {
        this.kilometrageActuel = kilometrageActuel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_revision() {
        return date_revision;
    }

    public void setDate_revision(String date_revision) {
        this.date_revision = date_revision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ambulance getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(Ambulance ambulance) {
        this.ambulance = ambulance;
    }

}
