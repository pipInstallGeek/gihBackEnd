package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    public String toString (){
        return this.getCodeEspace();
    }

}