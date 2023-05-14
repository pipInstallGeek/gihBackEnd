package ma.uiass.eia.pds.Model;



import javax.persistence.*;
import java.util.Date;

@Entity(name = "t_revision")
public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_revision")
    private int id;

    @Column(name = "date_revision")
    private Date date_revision;
    @Column(name = "description_revision")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_ambulance")
    private Ambulance ambulance;

    @ManyToOne
    @JoinColumn(name = "code_etat")
    private EtatsAmbulance etatAmbulance;

    public Revision() {
    }

    public Revision(Date date_revision, Ambulance ambulance, EtatsAmbulance etatAmbulance) {
        this.date_revision = date_revision;
        this.ambulance = ambulance;
        this.etatAmbulance = etatAmbulance;
    }

    public Revision(Date date_revision, String description, Ambulance ambulance, EtatsAmbulance etatAmbulance) {
        this.date_revision = date_revision;
        this.description = description;
        this.ambulance = ambulance;
        this.etatAmbulance = etatAmbulance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_revision() {
        return date_revision;
    }

    public void setDate_revision(Date date_revision) {
        this.date_revision = date_revision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtatAmbulance(EtatsAmbulance etatAmbulance) {
        this.etatAmbulance = etatAmbulance;
    }

    public Ambulance getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(Ambulance ambulance) {
        this.ambulance = ambulance;
    }

    public EtatsAmbulance getEtatAmbulance() {
        return etatAmbulance;
    }
}
