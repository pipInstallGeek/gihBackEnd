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

        public TypeLit( String nomTypeLit) {
                nomTypeLit = nomTypeLit;
        }

        public TypeLit(){ }
        public String toString(){
                return this.nomTypeLit;
        }


}
