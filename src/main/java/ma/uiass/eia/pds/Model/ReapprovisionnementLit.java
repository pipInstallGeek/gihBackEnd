package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_REAPPRO_LIT")
public class ReapprovisionnementLit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReap;

    @Column(nullable = false)
    private Integer quantiteReap;

    @Column(nullable = false)
    private LocalDateTime dateDemandeReap;

    @Column(nullable = false)
    private LocalDateTime dateLivraisonReap;

    @ManyToOne
    @JoinColumn(name = "lit_id", nullable = false)
    private Lit lit;

    public ReapprovisionnementLit() {

    }

    public Long getId() {
        return idReap;
    }

    public void setId(Long id) {
        this.idReap = id;
    }

    public Integer getQuantite() {
        return quantiteReap;
    }

    public void setQuantite(Integer quantite) {
        this.quantiteReap = quantite;
    }

    public LocalDateTime getDateDemande() {
        return dateDemandeReap;
    }

    public void setDateDemande(LocalDateTime dateDemande) {
        this.dateDemandeReap = dateDemande;
    }

    public LocalDateTime getDateLivraison() {
        return dateLivraisonReap;
    }

    public void setDateLivraison(LocalDateTime dateLivraison) {
        this.dateLivraisonReap = dateLivraison;
    }

    public Lit getLit() {
        return lit;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }

    public ReapprovisionnementLit(Integer quantiteReap, LocalDateTime dateLivraisonReap, Lit lit) {
        this.quantiteReap = quantiteReap;
        this.dateDemandeReap = LocalDateTime.now();
        this.dateLivraisonReap = dateLivraisonReap;
        this.lit = lit;
    }
}
