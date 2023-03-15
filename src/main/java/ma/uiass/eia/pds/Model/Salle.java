package ma.uiass.eia.pds.Model;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.*;
@Entity
@Table(name= "TSalle")
public class Salle extends Espace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalle;
    public Salle(String numEspace,Service service, String typeSalle) {
        super(numEspace,service);
        TypeSalle = typeSalle;
    }
    @Column(name = "TypeSalle", length = 50)
    private String TypeSalle;
    public void setTypeSalle(String typeSalle) {
        TypeSalle = typeSalle;
    }
    public String getTypeSalle() {
        return TypeSalle;
    }


}
=======

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
public class Salle extends Espace implements Serializable {

    @Column
    private String name;
}
>>>>>>> origin/dev
