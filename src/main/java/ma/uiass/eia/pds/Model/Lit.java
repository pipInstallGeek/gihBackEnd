package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Tlit")
public class Lit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLit;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatLit etatLit;

    @ManyToOne
    @JoinColumn(name = "idEspace", referencedColumnName = "idEspace")
    private Chambre chambre;

    @ManyToOne
    @JoinColumn(name = "idType", referencedColumnName = "idType") // id de type de lit
    private TypeLit typeLit;


    @ManyToOne
    @JoinColumn(name = "idMarque", referencedColumnName = "idMarque")
    private Marque marque;
    @OneToMany(mappedBy = "lit")
    private List<Equipement> equipements;
    public EtatLit getEtatLit() {
        return etatLit;
    }

    public void setEtatLit(EtatLit etatLit) {
        this.etatLit = etatLit;
    }

    public Lit(EtatLit etatLit) {
        setEtatLit(etatLit);
    }
    public Lit(){
    }

   public String toString(){return "Lit numero: "+ this.idLit+ "Etat: " + this.etatLit;}
}
