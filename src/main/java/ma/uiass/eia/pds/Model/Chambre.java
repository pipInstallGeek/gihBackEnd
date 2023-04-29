package ma.uiass.eia.pds.Model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

//import javax.persistence.*;
@Entity
@Table(name= "TChambre")
@DiscriminatorValue("chambre")

public class Chambre extends Espace implements Serializable {

    @Column(name="TypeChambre", length=50)
    private TypeChambre typeChambre;



    public void setTypeChambre(TypeChambre typeC) {
        this.typeChambre = typeC;
    }



    public TypeChambre getTypeChambre() {
        return typeChambre;
    }


    public Chambre(TypeChambre typeChambre, Service service) {
        super(service);
        this.typeChambre = typeChambre;
    }

    public Chambre() {
        super();
    }

}