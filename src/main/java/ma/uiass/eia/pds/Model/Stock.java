package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "TStock")
public class Stock extends Espace implements Serializable {
    public Stock() {
        super();
    }


    public Stock(String numEspace , Service service){
        super(numEspace,service);

    }

}
