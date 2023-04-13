package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "TSalle")
@DiscriminatorValue("salle")
public class Salle extends Espace implements Serializable {

    @Column(name = "TypeSalle", length = 50)
    private TypeSalle typeSalle;

    public void setTypeSalle(TypeSalle typeSalle) {
        this.typeSalle = typeSalle;
    }

    public TypeSalle getTypeSalle() {
        return typeSalle;
    }

    public Salle(String numEspace, TypeSalle typeSalle,Service service) {
        super(service);
        this.typeSalle = typeSalle;
    }

    public Salle() {
        super();
    }

}