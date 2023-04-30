package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class DetailsLivraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailsLivraison;

    @Column
    private int quantite;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idLivraisonFournisseur", referencedColumnName = "idLivraisonFournisseur")
    private LivraisonFournisseur livraisonFournisseur;

    @ManyToOne
    @JoinColumn(name = "idDispositifMedical", referencedColumnName = "idDispositifMedical")
    private DispositifMedical dispositifMedical;



    public DetailsLivraison(int quantite, LivraisonFournisseur livraisonFournisseur, DispositifMedical dispositifMedical) {
        this.quantite = quantite;
        this.livraisonFournisseur = livraisonFournisseur;
        this.dispositifMedical = dispositifMedical;
    }

}
