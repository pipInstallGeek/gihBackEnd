package ma.uiass.eia.pds.Model;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.*;

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
public abstract class Espace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idEspace;
    @Column(name="codeEspace", length=50)
    private String codeEspace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idService", referencedColumnName = "idService")
    private Service service;

    @JsonIgnore
    @OneToMany(mappedBy = "espace")
    public List<Lit> lit;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getIdEspace() {
        return idEspace;
    }

    public void setIdEspace(int idEspace) {
        this.idEspace = idEspace;
    }

    public void setCodeEspace(String numEspace) {
        this.codeEspace = numEspace;
    }

    public String getCodeEspace() {
        return codeEspace;
    }

    public List<Lit> getLit() {
        return lit;
    }
    public void setLit(List<Lit> lit) {
        this.lit = lit;
    }

    public Espace(Service service) {
        this.codeEspace = service.getCodeService()+this.getIdEspace();
        this.service = service;
    }

    public Espace() {

    }

    public String toString(){
        return this.codeEspace;
    }

}





