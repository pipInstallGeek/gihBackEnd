package ma.uiass.eia.pds.Model;

import javax.persistence.*;

@Entity
@Table(name = "TEtatAmbulance")
public class EtatsAmbulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;

    public EtatsAmbulance() {}

    public EtatsAmbulance(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }

}
