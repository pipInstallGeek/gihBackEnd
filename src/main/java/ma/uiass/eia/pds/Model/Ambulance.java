package ma.uiass.eia.pds.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "TAmbulance")
public class Ambulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambulance")
    private int id;

    @Column(name = "immatriculation")
    private String immatriculation;

    @Column
    private String marque;

    @Column
    private String model;

    @Column(name="date_mise_service")
    private LocalDate date_mise_service;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_etat")
    private EtatsAmbulance etatsAmbulance;

    @OneToMany(mappedBy = "ambulance")
    private List<HistoriqueEtats> historiqueEtats = new ArrayList<>();


    public Ambulance() {
    }


    public Ambulance(String immatriculation, String marque, String model, LocalDate date_mise_service, EtatsAmbulance etatsAmbulance) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.model = model;
        this.date_mise_service = date_mise_service;
        this.etatsAmbulance = etatsAmbulance;
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
        return etatsAmbulance;
    }

    public void setEtatAmbulance(EtatsAmbulance etatsAmbulance) {
        this.etatsAmbulance = etatsAmbulance;
    }

    public List<HistoriqueEtats> getHistoriqueEtats() {
        return historiqueEtats;
    }

    public void setHistoriqueEtats(List<HistoriqueEtats> historiqueEtats) {
        this.historiqueEtats = historiqueEtats;
    }
}

