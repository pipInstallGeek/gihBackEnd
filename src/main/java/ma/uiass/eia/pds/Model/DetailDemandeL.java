package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TDetailDemandeL")

public class DetailDemandeL implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDDL;

    public DetailDemandeL() {
    }

    public DetailDemandeL(String codeDetailDL, DemandeL demande, int quantite, TypeDM type) {
        this.codeDetailDL = codeDetailDL;
        this.demande = demande;
        this.quantite = quantite;
        this.type = type;
    }

    @Column(name="codeDetailDL")
    private String codeDetailDL;
    @JsonIgnore
    @JoinColumn(name = "idDemandeL",referencedColumnName = "idDemandeL")
    @ManyToOne
    private DemandeL demande;
    @Column(name="quantite")
    private int quantite;

    public int getIdDDL() {
        return idDDL;
    }

    public void setIdDDL(int idDDL) {
        this.idDDL = idDDL;
    }

    public String getCodeDetailDL() {
        return codeDetailDL;
    }

    public void setCodeDetailDL(String codeDetailDL) {
        this.codeDetailDL = codeDetailDL;
    }

    public DemandeL getDemande() {
        return demande;
    }

    public void setDemande(DemandeL demande) {
        this.demande = demande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public TypeDM getType() {
        return type;
    }

    public void setType(TypeDM type) {
        this.type = type;
    }

    @Column(name="TypeDM")
    private TypeDM type;







}
