package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "TEtatAmbulance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = F.class, name = "fonctionel"),
        @JsonSubTypes.Type(value = NFCD.class, name = "courteDuree"),
        @JsonSubTypes.Type(value = NFLD.class, name = "longueDurée"),
})
public abstract class EtatsAmbulance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etat")
    private int id;

    @Transient
    private static double A;
    @Transient
    private static double B;
    private double x;
    private double y;
    @OneToMany(mappedBy="etatAmbulance")
    private List<Ambulance> ambulance;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
