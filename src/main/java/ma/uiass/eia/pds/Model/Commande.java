package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "TCommande")
@Data
@NoArgsConstructor
public class Commande implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommande;
    @Column(name = "NumCommande", length = 50)
    private String numCommande;
    @Column(name = "Quantite", length = 50)
    private int quantite;
    @Column(name = "DateCommande", length = 50)
    private Date dateCommande;
    @Column(name = "DateLivraison", length = 50)
    private Date dateLivraison;
    @Column
    private Boolean confirmation;

    @ManyToMany
    @JoinTable(name = "detailsCommande", joinColumns = {@JoinColumn(name = "idCommande")}, inverseJoinColumns = {@JoinColumn(name = "idLit")})
    private List<Lit> lits;
    
   public Commande(String numCommande, int quantite, Date dateCommande, Date dateLivraison, Boolean confirmation, List<Lit> lits) {
        setNumCommande(numCommande);
        setQuantite(quantite);
        setDateCommande(dateCommande);
        setDateLivraison(dateLivraison);
        setConfirmation(confirmation);
    }
}
