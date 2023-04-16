package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TDM")
public class DescriptionDM implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDM;
    @Column(name="CodeDM", length=50)
    private String codeDM;
    @Column(name="NomDM", length=50)
    private String nomDM;
    @Column(name="Quantité", length=50)
    private int quantité;
    @JsonIgnore
    @OneToMany(mappedBy = "dmDescription", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<TypeDM> typeDMs = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "dmDescription", fetch = FetchType.LAZY )
    private List<ExemplaireDM> exemplaires = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "idEspace", referencedColumnName = "idEspace")
    private Espace espace;



    public DescriptionDM() {
    }
    public int getIdDM() {
        return idDM;
    }

    public void setIdDM(int idDM) {
        this.idDM = idDM;
    }

    public String getCodeDM() {
        return codeDM;
    }

    public void setCodeDM(String codeDM) {
        this.codeDM = codeDM;
    }


    public List<ExemplaireDM> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(List<ExemplaireDM> exemplaires) {
        this.exemplaires = exemplaires;
    }

    public Espace getEspace() {
        return espace;
    }

    public void setEspace(Espace espace) {
        this.espace = espace;
    }

    public DescriptionDM(String nomDM, int quantité, Espace espace) {
        this.espace=espace;
        this.nomDM = nomDM;
        this.quantité = quantité;
       // this.typeDMs = typeDMs;
    }

    public String getNomDM() {
        return nomDM;
    }

    public void setNomDM(String nomDM) {
        this.nomDM = nomDM;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public List<TypeDM> getTypeDMs() {
        return typeDMs;
    }

    public void setTypeDMs(List<TypeDM> typeDMs) {
        this.typeDMs = typeDMs;
    }
}
