package ma.uiass.eia.pds.Model;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "TEspace")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Chambre.class, name = "chambre"),
        @JsonSubTypes.Type(value = Salle.class, name = "salle"),
})
@Data
@NoArgsConstructor
public abstract class Espace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idEspace;
    @Column(name="codeEspace", length=50)
    private String codeEspace;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idService", referencedColumnName = "idService")
    private Service service;

    @JsonIgnore
    @OneToMany(mappedBy = "espace")
    public List<Lit> lit;


    @JsonIgnore
    @OneToMany(mappedBy = "espace")
    public List<DispositifMedical> dispositifMedical;




    public Espace(Service service) {
        this.service = service;
    }


    public String toString(){
        return this.codeEspace;
    }

}





