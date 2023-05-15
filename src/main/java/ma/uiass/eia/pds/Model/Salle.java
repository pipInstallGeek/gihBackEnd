package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name= "TSalle")
@Data
@DiscriminatorValue("salle")
public class Salle extends Espace implements Serializable {

    @Column(name = "TypeSalle", length = 50)
    private TypeSalle typeSalle;


    public Salle(TypeSalle typeSalle,Service service) {
        super(service);
        this.typeSalle = typeSalle;
    }

    public Salle() {
        super();
    }


}


