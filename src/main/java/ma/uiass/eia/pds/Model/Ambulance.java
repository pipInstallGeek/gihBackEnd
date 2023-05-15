package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TAmbulance")
public class Ambulance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambulance")
    private int id;

    @Column(name = "immatriculation")
    private String immatriculation;

    @Column
    private String kilometrage;

    @Column(name="date_mise_service")
    private String date_mise_service;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_etat")
    private EtatsAmbulance etatsAmbulance;



    public Ambulance() {
    }


    public Ambulance(String immatriculation, String kilometrage, String date_mise_service) {
        this.immatriculation = immatriculation;
        this.kilometrage = kilometrage;
        this.date_mise_service = date_mise_service;
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



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public EtatsAmbulance getEtatAmbulance() {
        return etatsAmbulance;
    }

    public void setEtatAmbulance(EtatsAmbulance etatsAmbulance) {
        this.etatsAmbulance = etatsAmbulance;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public EtatsAmbulance getEtatsAmbulance() {
        return etatsAmbulance;
    }

    public void setEtatsAmbulance(EtatsAmbulance etatsAmbulance) {
        this.etatsAmbulance = etatsAmbulance;
    }
}

