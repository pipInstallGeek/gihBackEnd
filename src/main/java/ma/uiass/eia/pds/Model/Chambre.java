package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.*;
@Entity
@Table(name= "TChambre")
public class Chambre extends Espace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChambre;

    @Column(name="TypeChambre", length=50)
    private String typeChambre;

    public void setTypeChambre(String typeC) {
        this.typeChambre = typeC;
    }

    public String getTypeChambre() {
        return typeChambre;
    }
    public Chambre(String numEspace,Service service, String typeChambre) {
        super(numEspace,service);
        this.typeChambre = typeChambre;
    }


}
