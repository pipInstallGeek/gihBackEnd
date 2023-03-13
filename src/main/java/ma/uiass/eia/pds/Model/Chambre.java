package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.*;
@Entity
@Table(name= "TChambre")
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChambre;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idService", referencedColumnName = "idService")
    private Service service;

    @Column(name="NumChambre", length=50)
    private String numChambre;
    @Column(name="Etage",length=50)
    private String etage;


    @OneToMany(mappedBy = "chambre", fetch = FetchType.LAZY )
    private List<Lit> lits = new ArrayList<>();



    public void setService(Service service) {
        this.service = service;
    }
    @Column(name="TypeChambre", length=50)
    private String typeChambre;

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }



    public void setNumChambre(String numC) {
        this.numChambre = numC;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public void setTypeChambre(String typeC) {
        this.typeChambre = typeC;
    }

    public Service getService() {
        return service;
    }


    public String getNumChambre() {
        return numChambre;
    }

    public String getEtage() {
        return etage;
    }

    public String getTypeChambre() {
        return typeChambre;
    }


    public Chambre(String numChambre, String etage, String typeChambre, Service service) {
        this.numChambre = numChambre;
        this.etage = etage;
        this.typeChambre = typeChambre;
        this.service = service;
    }

    public Chambre() {
    }







}
