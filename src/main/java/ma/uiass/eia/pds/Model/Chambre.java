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
@Table(name= "TChambre")
@DiscriminatorValue("chambre")
@Data
public class Chambre extends Espace implements Serializable {


    @Column(name = "NumChambre", length = 50)
    private String numChambre;

    @Column(name = "TypeChambre", length = 50)
    private TypeChambre typeChambre;



    public Chambre( TypeChambre typeChambre, Service service) {
        super(service);
        setTypeChambre(typeChambre);
    }

    public Chambre() {
        super();
    }

    public String toString() {
        return this.getCodeEspace();
    }
}
