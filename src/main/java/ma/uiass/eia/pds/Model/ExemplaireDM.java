    package ma.uiass.eia.pds.Model;

    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.io.Serializable;

    @Entity
    @Table(name="TDMExemplaire")
    @Data
    @NoArgsConstructor
    public class ExemplaireDM implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idDME;

        @Column(name="CodeDME", length=50)
        private String codeDME;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
        @JoinColumn(name = "idDispositifMedical", referencedColumnName = "idDispositifMedical")
        private DispositifMedical dmDescription;




        public ExemplaireDM( DispositifMedical dmDescription) {
            this.dmDescription = dmDescription;
        }
        public String toString(){
            return this.getCodeDME();
        }

    }
