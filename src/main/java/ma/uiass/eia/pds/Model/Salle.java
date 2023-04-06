package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name= "TSalle")
public class Salle extends Espace implements Serializable {

    @Column(name = "TypeSalle", length = 50)
    @Enumerated(EnumType.STRING)
    private TypeSalle TypeSalle;
    @Column(name="NumSalle", length=50)
    private String numSalle;
    public void setTypeSalle(TypeSalle typeSalle) {
        TypeSalle = typeSalle;
    }
    public TypeSalle getTypeSalle() {
        return TypeSalle;
    }
    public Salle(String numSalle, TypeSalle typeSalle,Service service) {
        super(service);
        this.TypeSalle = typeSalle;
        this.numSalle =numSalle;
        this.typeEspace = "salle";
    }
    public Salle() {
        super();
    }
    public String toString(){
        return this.numSalle;
    }

}