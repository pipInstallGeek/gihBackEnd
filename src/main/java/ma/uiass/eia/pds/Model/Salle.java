package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.*;
@Entity
@Table(name= "TSalle")
public class Salle extends Espace implements Serializable {

    @Column(name = "TypeSalle", length = 50)
    private TypeSalle typeSalle;

    public void setTypeSalle(TypeSalle typeSalle) {
        this.typeSalle = typeSalle;
    }

    public TypeSalle getTypeSalle() {
        return this.typeSalle;
    }

    public Salle(String numEspace, TypeSalle typeSalle,Service service) {
        super(service);
        this.typeSalle = typeSalle;
    }

    public Salle() {
        super();
    }


}

