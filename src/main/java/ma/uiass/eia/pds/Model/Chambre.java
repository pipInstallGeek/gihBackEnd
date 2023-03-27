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



    @Column(name="TypeChambre", length=50)
    private TypeChambre typeChambre;



    public void setTypeChambre(TypeChambre typeC) {
        this.typeChambre = typeC;
    }



    public TypeChambre getTypeChambre() {
        return typeChambre;
    }


    public Chambre(String numEspace ,TypeChambre typeChambre, Service service) {
        super(numEspace, service);
        this.typeChambre = typeChambre;
    }

    public Chambre() {
        super();
    }
}
