package ma.uiass.eia.pds.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "t_ambulance")
public class Ambulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambulance")
    private int id;

    @Column(name = "immatriculation", unique = true)
    private String immatriculation;

    @Column(name="date_mise_service")
    private LocalDate date_mise_service;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_etat")
    private EtatsAmbulance etatAmbulance = new F();

    @Column(name = "estimated_date_revision")
    private LocalDate estimatedRevisionDate;

    public Ambulance() {
    }

    public Ambulance(String immatriculation, EtatsAmbulance etatAmbulances) {
        this.immatriculation = immatriculation;
        this.date_mise_service = LocalDate.now();
        this.etatAmbulance = etatAmbulances;
    }

    public Ambulance(String immatriculation, LocalDate date_mise_service, EtatsAmbulance etatAmbulance, LocalDate estimatedRevisionDate) {
        this.immatriculation = immatriculation;
        this.date_mise_service = date_mise_service;
        this.etatAmbulance = etatAmbulance;
        this.estimatedRevisionDate = estimatedRevisionDate;
    }

    public LocalDate getDate_mise_service() {
        return date_mise_service;
    }

    public void setDate_mise_service(LocalDate date_mise_service) {
        this.date_mise_service = date_mise_service;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public EtatsAmbulance getEtatAmbulance() {
        return etatAmbulance;
    }

    public void setEtatAmbulance(EtatsAmbulance etatAmbulance) {
        this.etatAmbulance = etatAmbulance;
    }

    public LocalDate getEstimatedRevisionDate() {
        return estimatedRevisionDate;
    }

    public void setEstimatedRevisionDate(LocalDate estimatedRevisionDate) {
        this.estimatedRevisionDate = estimatedRevisionDate;
    }
}


