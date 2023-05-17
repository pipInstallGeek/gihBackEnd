package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TAmbulance")
public class Ambulance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambulance")
    private int id;

    @Column(name = "immatriculation", unique = true)
    private String immatriculation;

    @Column(name="date_mise_service")
    private String date_mise_service;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_etat")
    private EtatsAmbulance etatAmbulance = new F() ;

    @Column(name = "estimated_date_revision")
    private String estimatedRevisionDate;

    @Column(name = "kilometrage")
    private String kilometrage;

    public Ambulance() {
    }

    public Ambulance(String immatriculation,String date_mise_service) {
        this.immatriculation = immatriculation;
        this.date_mise_service = date_mise_service;
        this.etatAmbulance = new F();
    }

    public Ambulance(String immatriculation, String date_mise_service, String estimatedRevisionDate) {
        this.immatriculation = immatriculation;
        this.date_mise_service = date_mise_service;
        this.etatAmbulance = new F();
        this.estimatedRevisionDate = estimatedRevisionDate;
    }

    public Ambulance(String immatriculation, String date_mise_service, String estimatedRevisionDate, String kilometrage) {
        this.immatriculation = immatriculation;
        this.date_mise_service = date_mise_service;
        this.etatAmbulance = new F();
        this.estimatedRevisionDate = estimatedRevisionDate;
        this.kilometrage = kilometrage;
    }

    public String getDate_mise_service() {
        return date_mise_service;
    }

    public void setDate_mise_service(String date_mise_service) {
        this.date_mise_service = date_mise_service;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
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

    public String getEstimatedRevisionDate() {
        return estimatedRevisionDate;
    }

    public void setEstimatedRevisionDate(String estimatedRevisionDate) {
        this.estimatedRevisionDate = estimatedRevisionDate;
    }

    @Override
    public String toString() {
        return immatriculation ;
    }
}


