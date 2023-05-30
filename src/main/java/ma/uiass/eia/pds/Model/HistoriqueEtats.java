package ma.uiass.eia.pds.Model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "THistoriqueEtatambulance")
public class HistoriqueEtats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_debut")
    LocalDate date_debut;

    @Column(name = "date_prochaine_revision")
    LocalDate date_prochaine_revision;



    public HistoriqueEtats() {}

    public HistoriqueEtats(int id) {
        this.id = id;
    }

    public HistoriqueEtats(LocalDate date_debut, LocalDate date_prochaine_revision, Ambulance ambulance, EtatsAmbulance etatsAmbulance) {
        this.date_debut = date_debut;
        this.date_prochaine_revision = date_prochaine_revision;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_prochaine_revision() {
        return date_prochaine_revision;
    }

    public void setDate_prochaine_revision(LocalDate date_prochaine_revision) {
        this.date_prochaine_revision = date_prochaine_revision;
    }

}

