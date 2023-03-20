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
    private TypeSalle TypeSalle;

    public void setTypeSalle(TypeSalle typeSalle) {
        TypeSalle = typeSalle;
    }

    public TypeSalle getTypeSalle() {
        return TypeSalle;
    }

    public Salle(String numEspace, TypeSalle typeSalle,Service service) {
        super(numEspace,service);
        this.TypeSalle = typeSalle;
    }

    public Salle() {

    }


}

