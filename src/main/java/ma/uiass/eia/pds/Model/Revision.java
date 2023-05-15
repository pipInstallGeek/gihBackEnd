package ma.uiass.eia.pds.Model;



import java.util.Date;

import jakarta.persistence.*;

@Entity(name = "TRevision")
public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_revision")
    private int id;

    @Column(name = "date_revision")
    private Date date_revision;

    @ManyToOne
    @JoinColumn(name = "id_ambulance")
    private Ambulance ambulance;

    @ManyToOne
    @JoinColumn(name = "code_etat")
    private EtatsAmbulance etatsAmbulance;

    public Revision() {
    }

    public Revision(Date date_revision, Ambulance ambulance, EtatsAmbulance etatsAmbulance) {
        this.date_revision = date_revision;
        this.ambulance = ambulance;
        this.etatsAmbulance = etatsAmbulance;
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

    public Ambulance getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(Ambulance ambulance) {
        this.ambulance = ambulance;
    }

    public EtatsAmbulance getEtatAmbulance() {
        return etatsAmbulance;
    }
}
