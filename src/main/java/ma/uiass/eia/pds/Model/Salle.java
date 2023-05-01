package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.*;
@Entity
@Table(name= "TSalle")
@Data
@DiscriminatorValue("salle")
public class Salle extends Espace implements Serializable {

    @Column(name = "TypeSalle", length = 50)
    private TypeSalle typeSalle;


    public Salle(String numEspace, TypeSalle typeSalle,Service service) {
        super(service);
        this.typeSalle = typeSalle;
    }

    public Salle() {
        super();
    }


}


