package ma.uiass.eia.pds.Model;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "TEspace")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Espace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspace;
    @Column(name="NumEspace", length=50)
    private String numEspace;
    @OneToMany(mappedBy = "espace", fetch = FetchType.LAZY )
    private List<Lit> lits = new ArrayList<>();
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idService", referencedColumnName = "idService")
    private Service service;
    public void setNumEspace(String numEspace) {
        this.numEspace = numEspace;
    }
    public Espace(String numEspace, Service service) {
        this.numEspace = numEspace;
        this.service = service;
    }
    public String getNumEspace() {
        return numEspace;
    }
    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;
    @Enumerated(EnumType.STRING)
    private TypeSalle typeSalle;


}





