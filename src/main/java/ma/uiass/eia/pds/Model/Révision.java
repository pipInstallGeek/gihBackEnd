package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name= "TRévision")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Révision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRévision;

    public Révision(String dateRévision, Ambulance ambulance) {
        this.dateRévision = dateRévision;
        this.ambulance = ambulance;
    }

    @Column(name="codeRévision", length=50)
    private String codeRévision;
    @Column(name="dateRévision", length=50)
    private String dateRévision;
    @Column(name="dateProRévision", length=50)
    private String dateProRévision;
    @Column(name="dateSortie", length=50)
    private String dateSortie;

    public Révision(String dateRévision, String dateProRévision, String description) {
        this.dateRévision = dateRévision;
        this.dateProRévision = dateProRévision;
        this.description = description;
    }

    public Révision(String dateRévision, String dateProRévision, String description, TypeRévision typeR) {
        this.dateRévision = dateRévision;
        this.dateProRévision = dateProRévision;
        this.description = description;
        this.typeR = typeR;
    }

    public Révision(String dateRévision,double kilométrage,String dateSortie, String dateProRévision, String description, TypeRévision typeR, Ambulance ambulance) {
        this.dateRévision = dateRévision;
        this.dateProRévision = dateProRévision;
        this.description = description;
        this.typeR = typeR;
        this.ambulance = ambulance;
        this.dateSortie=dateSortie;
        this.ambulance.setKilométrage(kilométrage);
    }

    public Révision(String dateRévision, TypeRévision typeR,double kilométrage,Ambulance am,String description) {
        this.dateRévision = dateRévision;
        this.typeR = typeR;
        this.ambulance.setKilométrage(kilométrage);
        this.ambulance=am;
        this.description=description;
    }
    @Column(name="description")
    private String description;
    @Column(name="typeR", length=50)
    @Enumerated(EnumType.STRING)
    private TypeRévision typeR;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAmbulance", referencedColumnName = "idAmbulance")
    private Ambulance ambulance;

}
