package ma.uiass.eia.pds.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.util.List;


@Table(name= "TAmbulance")
@Data
@Entity
@NoArgsConstructor

public class Ambulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAmbulance;

    @Column
    private String immatruculation;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column
    private LocalDate dateCirucaltion;

    @JsonIgnore
    @OneToMany(mappedBy = "ambulance",cascade = CascadeType.ALL)
    private List<Révision> revisions;



    /*@Column(name="CodeAmbulance", length=50)
    private String codeAmbulance;*/

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name="DateCreation", length=50)
    private LocalDate dateCreation;
    @Column(name="Kilometrage", length=50)
    private double kilometrage;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idState",referencedColumnName ="idState" )
    private StateAMB state;
    public Ambulance(String immatruculation, LocalDate dateCirucaltion){
        setDateCirucaltion(dateCirucaltion);
        setImmatruculation(immatruculation);
    }

    public Ambulance(LocalDate dateCirucaltion, double kilometrage) {
        this.dateCirucaltion = dateCirucaltion;
        this.kilometrage = kilometrage;
    }

    public Ambulance(String matricule, LocalDate dateCirucaltion, double kilometrage){
    	this.kilometrage = kilometrage;
    	this.immatruculation = matricule;
    	this.dateCirucaltion = dateCirucaltion;
    }
    public  String toString(){
        return this.immatruculation;
    }


}
