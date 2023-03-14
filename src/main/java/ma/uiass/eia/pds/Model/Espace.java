package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tespace")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Espace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
