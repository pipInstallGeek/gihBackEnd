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
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idEspace;
    @Column(name="NumEspace", length=50)
    private String numEspace;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idService", referencedColumnName = "idService")
    private Service service;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "idEspace", referencedColumnName = "idEspace")
    public List<Lit> lit;

    public int getIdEspace() {
        return idEspace;
    }

    public void setIdEspace(int idEspace) {
        this.idEspace = idEspace;
    }

    public void setNumEspace(String numEspace) {
        this.numEspace = numEspace;
    }

    public String getNumEspace() {
        return numEspace;
    }

    public Espace(String numEspace, Service service) {
        this.numEspace = numEspace;
        this.service = service;
    }
    public Espace() {
    }
    public String toString(){
        return this.numEspace;
    }

}





