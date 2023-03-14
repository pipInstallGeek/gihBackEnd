package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tespace")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Espace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idEspace;

    public void setIdEspace(int id) {
        this.idEspace = id;
    }
    public int getIdEspace() {
        return idEspace;
    }
}
