package ma.uiass.eia.pds.Model;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "TChambre")
public class Chambre extends Espace implements Serializable {
    @Column(name="NumChambre", length=50)
    private String numChambre;
    @Column(name="TypeChambre", length=50)
    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;
    public void setNumChambre(String numC) {
        this.numChambre = numC;
    }
    public void setTypeChambre(TypeChambre typeC) {
        this.typeChambre = typeC;
    }
    public String getNumChambre() {
        return numChambre;
    }
    public TypeChambre getTypeChambre() {
        return typeChambre;
    }
    public Chambre(String numChambre, TypeChambre typeChambre, Service service) {
        super( service);
        this.numChambre = numChambre;
        this.typeChambre = typeChambre;
        this.typeEspace = "chambre";
    }
    //public Chambre() {
       // super();
    //}
    public Chambre(){}
    public String getNom(){return "Chambre" ;}







}


