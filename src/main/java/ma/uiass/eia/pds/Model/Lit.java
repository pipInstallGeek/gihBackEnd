package ma.uiass.eia.pds.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column
    private Boolean occupe;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idEspace", referencedColumnName = "idEspace")
    private Espace espace;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idType", referencedColumnName = "idType") // id de type de lit
    private TypeLit typeLit;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idMarque", referencedColumnName = "idMarque")
    private Marque marque;
    @OneToMany(mappedBy = "lit")
    private List<Equipement> equipements;

    public int getIdLit() {
        return idLit;
    }

    public void setIdLit(int idLit) {
        this.idLit = idLit;
    }

    public Boolean getOccupe() {
        return occupe;
    }

    public void setOccupe(Boolean occupe) {
        this.occupe = occupe;
    }

    public List<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<Equipement> equipements) {
        this.equipements = equipements;
    }

    public EtatLit getEtatLit() {
        return etatLit;
    }

    public void setEtatLit(EtatLit etatLit ) {
        this.etatLit = etatLit;
    }

    public TypeLit getTypeLit() {
        return typeLit;
    }

    public void setTypeLit(TypeLit typeLit) {
        this.typeLit = typeLit;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Espace getEspace() {
        return espace;
    }

    public void setEspace(Espace espace) {
        this.espace = espace;
    }

    public Lit(Marque marque, TypeLit typeLit, Boolean occupe, EtatLit etatLit, Espace espace) {
        setMarque(marque);
        setTypeLit(typeLit);
        setEtatLit(etatLit);
        setEspace(espace);
        setOccupe(occupe);
    }
    public Lit(){
    }

   public String toString(){return "Lit numero: "+ this.idLit+ "Etat: " + this.etatLit;}
}
