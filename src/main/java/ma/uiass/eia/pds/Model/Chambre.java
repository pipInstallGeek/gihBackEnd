package ma.uiass.eia.pds.Model;
import jakarta.persistence.*;

import java.io.Serializable;

//import javax.persistence.*;
@Entity
@Table(name= "TChambre")
@DiscriminatorValue("chambre")

public class Chambre extends Espace implements Serializable {

    @Column(name="TypeChambre", length=50)
    private String typeChambre;



    public void setTypeChambre(String typeC) {
        this.typeChambre = typeC;
    }



    public String getTypeChambre() {
        return typeChambre;
    }


    public Chambre(String typeChambre, Service service) {
        super(service);
        this.typeChambre = typeChambre;
    }

    public Chambre() {
        super();
    }
}
