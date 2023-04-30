    package ma.uiass.eia.pds.Model;
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonProperty;
    import jakarta.persistence.*;
    import java.io.Serializable;
    import java.util.Date;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @Table(name= "TAdmission")
    @Data
    @NoArgsConstructor
    public class Admission implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idAdmission;
        @Column(name="NumAdmission", length=50)
        private String numAdmission;
        @Column(name="DateDébut", length=50)
        private String dateDébut;
        @Column(name="DateFin", length=50)
        private String dateFin;
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "idLit",referencedColumnName = "idLit")
        private Lit lit;


        public Admission(String numAdmission, String dateE, Lit lit) {
            this.numAdmission=numAdmission;
            this.dateDébut=dateE;
            this.lit=lit;
        }


        public Admission(String numAdmission, String dateDébut, String dateFin, Lit lit) {
            this.numAdmission = numAdmission;
            this.dateDébut = dateDébut;
            this.dateFin = dateFin;
            this.lit = lit;

        }

        public String toString(){
            return this.idAdmission + " "+this.numAdmission+" "+" "+this.dateDébut+" "+this.dateFin +" "+this.lit.getIdLit();        }

    }
