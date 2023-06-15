package ma.uiass.eia.pds.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "Tlit")
@Data
@NoArgsConstructor
public class Lit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLit;

    @Column
    private String codeLit;
    @Column
    @Enumerated(EnumType.STRING)
    private EtatLit etatLit;
    @Column
    private Boolean occupe;


    @ManyToOne
    @JoinColumn(name = "idEspace", referencedColumnName = "idEspace")
    private Espace espace;

    @JsonIgnore
    @OneToMany(mappedBy = "lit")
    private List<Admission> admissions;


    @ManyToOne
    @JoinColumn(name = "idType", referencedColumnName = "idType") // id de type de lit
    private TypeLit typeLit;


    @ManyToOne
    @JoinColumn(name = "idMarque", referencedColumnName = "idMarque")
    private Marque marque;

    @JsonIgnore
    @OneToMany(mappedBy = "lit")
    private List<Equipement> equipements;

    @JsonIgnore
    @ManyToMany(mappedBy = "lits")
    private List<Commande> commandes;



    public Lit(EtatLit etatLit, Boolean occupe, Espace espace,  TypeLit typeLit, Marque marque) {
        this.etatLit = etatLit;
        this.occupe = occupe;
        this.espace = espace;
        this.typeLit = typeLit;
        this.marque = marque;
    }

    public String toString(){return this.codeLit;}

}
