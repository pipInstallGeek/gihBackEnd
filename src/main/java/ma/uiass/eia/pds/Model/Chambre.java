package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.*;
@Entity
@Table(name= "TChambre")
public class Chambre extends Espace implements Serializable {


    @Column(name="NumChambre", length=50)
    private String numChambre;

    @Column(name="TypeChambre", length=50)
    private TypeChambre typeChambre;



    public void setNumChambre(String numC) {
        this.numChambre = numC;
    }


    public void setTypeChambre(TypeChambre typeC) {
        this.typeChambre = typeC;
    }



    public String getNumChambre() {
        return numChambre;
    }


    public TypeChambre getTypeChambre() {
        return typeChambre;
    }


    public Chambre(String numChambre, TypeChambre typeChambre,String numEspace, Service service) {
        super(numEspace, service);
        this.numChambre = numChambre;
        this.typeChambre = typeChambre;
    }

    public Chambre() {
        super();
    }







}
