package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "TMarque")
@Data
@NoArgsConstructor
public class Marque implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarque;
    @Column(length =40,name="codeMarque")
    private String codeMarque;
    @Column(length = 40,name="nomMarque")
    private String nomMarque;
    @JsonIgnore
    @OneToMany(mappedBy = "marque")
    private List<Lit> lits=new ArrayList<>();



    public Marque(String codeMarque, String nomMarque) {
        this.codeMarque = codeMarque;
        this.nomMarque = nomMarque;
    }

    public String toString(){
        return this.nomMarque;
    }

}