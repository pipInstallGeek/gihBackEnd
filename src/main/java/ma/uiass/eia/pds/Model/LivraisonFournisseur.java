package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "livraisonFournisseur")
public class LivraisonFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLivraisonFournisseur;

    @Column
    private String codeLivraisonFournisseur;

    @Column
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateLivraisonFournisseur;
    @ManyToOne()
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "livraisonFournisseur")
    private List<DetailsLivraison> detailsLivraisons;

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getIdLivraisonFournisseur() {
        return idLivraisonFournisseur;
    }

    public void setIdLivraisonFournisseur(int idLivraisonFournisseur) {
        this.idLivraisonFournisseur = idLivraisonFournisseur;
    }

    public LocalDate getDateLivraisonFournisseur() {
        return dateLivraisonFournisseur;
    }

    public void setDateLivraisonFournisseur(LocalDate dateLivraisonFournisseur) {
        this.dateLivraisonFournisseur = dateLivraisonFournisseur;
    }

    public String getCodeLivraisonFournisseur() {
        return codeLivraisonFournisseur;
    }

    public void setCodeLivraisonFournisseur(String codeLivraisonFournisseur) {
        this.codeLivraisonFournisseur = codeLivraisonFournisseur;
    }



    public List<DetailsLivraison> getDetailsLivraisons() {
        return detailsLivraisons;
    }

    public void setDetailsLivraisons(List<DetailsLivraison> detailsLivraisons) {
        this.detailsLivraisons = detailsLivraisons;
    }
    public LivraisonFournisseur(String codeLivraisonFournisseur, LocalDate dateLivraisonFournisseur, Fournisseur fournisseur) {
        this.codeLivraisonFournisseur = codeLivraisonFournisseur;
        this.dateLivraisonFournisseur = dateLivraisonFournisseur;
        this.fournisseur = fournisseur;
    }

    public LivraisonFournisseur(){

    }
}
