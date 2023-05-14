package ma.uiass.eia.pds.Model;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@NoArgsConstructor

public class Ambulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAmbulance;

    @Column
    private String immatruculation;

    @Column
    private LocalDate dateCirucaltion;

    @ManyToOne
    @JoinColumn(name = "idEtatAmbulance", referencedColumnName = "idEtatAmbulance")
    private EtatAmbulance etatAmbulance;

    @OneToMany(mappedBy = "ambulance")
    private List<Revision> revisions;

    @OneToOne
    @JoinColumn(name = "idAmbulance", referencedColumnName ="idAmbulance")
    private EtatHistory etatHistory;

    public Ambulance(String immatruculation, LocalDate dateCirucaltion){
        setDateCirucaltion(dateCirucaltion);
        setImmatruculation(immatruculation);
    }
}
