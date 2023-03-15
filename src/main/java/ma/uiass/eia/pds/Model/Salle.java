package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
public class Salle extends Espace implements Serializable {

    @Column
    private String name;
}
