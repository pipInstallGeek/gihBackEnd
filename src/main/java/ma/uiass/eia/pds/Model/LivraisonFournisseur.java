package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "livraisonFournisseur")
@Data
@NoArgsConstructor
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


    public LivraisonFournisseur(String codeLivraisonFournisseur, LocalDate dateLivraisonFournisseur, Fournisseur fournisseur) {
        this.codeLivraisonFournisseur = codeLivraisonFournisseur;
        this.dateLivraisonFournisseur = dateLivraisonFournisseur;
        this.fournisseur = fournisseur;
    }


}
