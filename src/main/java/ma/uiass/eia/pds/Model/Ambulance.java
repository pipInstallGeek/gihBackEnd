package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "TAmbulance")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Ambulance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAmbulance;

    @Column(name="CodeAmbulance", length=50)
    private String codeAmbulance;
    @Column(name="DateMiseEnCirculation", length=50)
    private String dateMiseEnCirculation;
    @Column(name="DateCréation", length=50)
    private String dateCréation;
    @Column(name="Kilométrage", length=50)
    private double kilométrage;

    @JsonIgnore
    @OneToMany(mappedBy = "ambulance", fetch = FetchType.LAZY )
    private List<Révision> révisions = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idState",referencedColumnName ="idState" )
    private StateAMB state;


    public Ambulance(String dateMiseEnCirculation, String dateCréation, List<Révision> révisions) {
        this.dateMiseEnCirculation = dateMiseEnCirculation;
        this.dateCréation = dateCréation;
        this.révisions = révisions;
    }

    public Ambulance(String dateMiseEnCirculation, String dateCréation, double kilométrage) {
        this.dateMiseEnCirculation = dateMiseEnCirculation;
        this.dateCréation = dateCréation;
       this.kilométrage=kilométrage;
    }

    public Ambulance(String dateMiseEnCirculation, String dateCréation) {
        this.dateMiseEnCirculation = dateMiseEnCirculation;
        this.dateCréation = dateCréation;
    }
    public  String toString(){
        return this.codeAmbulance;
    }


}
