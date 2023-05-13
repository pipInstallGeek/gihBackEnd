package ma.uiass.eia.pds.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public Révision(String dateRévision, String dateProRévision, String description, TypeRévision typeR, Ambulance ambulance) {
        this.dateRévision = dateRévision;
        this.dateProRévision = dateProRévision;
        this.description = description;
        this.typeR = typeR;
        this.ambulance = ambulance;
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
