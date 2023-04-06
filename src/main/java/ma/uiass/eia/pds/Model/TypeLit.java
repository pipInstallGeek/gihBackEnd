package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "TypeLit")
public class TypeLit implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idType;

        @Column(length =40,name="codeTypelit")
        private String codeTypelit;
        @Column(length = 40,name="nomType")
        private String nomTypeLit;
        @JsonIgnore
        @OneToMany(mappedBy = "typeLit")
        private List<Lit> lits;

        public int getIdType() {
                return idType;
        }

        public void setIdType(int id_T) {
                this.idType = id_T;
        }

        public String getCodeTypelit() {
                return codeTypelit;
        }

        public void setCodeTypelit(String codeTypelit) {
                this.codeTypelit = codeTypelit;
        }

        public String getNomTypeLit() {
                return nomTypeLit;
        }

        public void setNomTypeLit(String nomTypeLit) {
                this.nomTypeLit = nomTypeLit;
        }

        public List<Lit> getLits() {
                return lits;
        }

        public void setLits(List<Lit> lits) {
                this.lits = lits;
        }

        public TypeLit( String codeTypelit,String nomTypeLit) {
                this.nomTypeLit = nomTypeLit;
                this.codeTypelit=codeTypelit;
        }

        public TypeLit(){ }

        @Override
        public String toString() {
                return  nomTypeLit ;
        }
}
