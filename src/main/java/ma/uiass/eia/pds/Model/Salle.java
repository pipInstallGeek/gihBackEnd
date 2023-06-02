package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "TSalle")
@DiscriminatorValue("salle")
public class Salle extends Espace implements Serializable {

    @Column(name = "TypeSalle", length = 50)
    private String typeSalle;

    public void setTypeSalle(String typeSalle) {
        this.typeSalle = typeSalle;
    }

    public String getTypeSalle() {
        return typeSalle;
    }

    public Salle(String numEspace, String typeSalle, Service service) {
        super(service);
        this.typeSalle = typeSalle;
    }
    public Salle(String typeSalle){
        this.typeSalle= typeSalle;
    }

    public Salle() {
        super();
    }
}

