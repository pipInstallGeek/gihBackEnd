package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table@Data
@NoArgsConstructor
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String idFiscal;

    @Column
    private String adresse;
    @Column
    private String email;


    @OneToMany(mappedBy = "fournisseur")
    @JsonIgnore
    private List<LivraisonFournisseur> livraisonFournisseurs;

    public Fournisseur(String idFiscal, String adresse, String email){
        setIdFiscal(idFiscal);
        setAdresse(adresse);
        setEmail(email);

    }
    public String toString(){
        return this.getIdFiscal()+ " "+this.getEmail();
    }

}