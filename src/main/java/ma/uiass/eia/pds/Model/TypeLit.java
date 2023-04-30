package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "TypeLit")
@Data
@NoArgsConstructor
public class TypeLit implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idType;

        @Column(length = 40,name="nomType")
        private String nomTypeLit;
        @Column(length = 40,name="codeType")
        private String codeType;
        @JsonIgnore
        @OneToMany(mappedBy = "typeLit")
        private List<Lit> lits;


        public TypeLit( String nomTypeLit,String codeType) {
                this.codeType=codeType;
                this.nomTypeLit = nomTypeLit;
        }

        public String toString(){
                return this.nomTypeLit;
        }


}