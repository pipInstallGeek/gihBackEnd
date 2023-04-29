    package ma.uiass.eia.pds.Model;

    import jakarta.persistence.*;

    import java.io.Serializable;

    @Entity
    @Table(name="TDMExemplaire")
    public class ExemplaireDM implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idDME;
        @Column(name="CodeDME", length=50)
        private String codeDME;
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
        @JoinColumn(name = "idDM", referencedColumnName = "idDM")
        private DescriptionDM dmDescription;

        public ExemplaireDM() {
        }

        public ExemplaireDM( DescriptionDM dmDescription) {
           // this.codeDME = codeDME;
            this.dmDescription = dmDescription;
        }

        public int getIdDME() {
            return idDME;
        }

        public void setIdDME(int idDME) {
            this.idDME = idDME;
        }

        public String getCodeDME() {
            return codeDME;
        }

        public void setCodeDME(String codeDME) {
            this.codeDME = codeDME;
        }

        public DescriptionDM getDmDescription() {
            return dmDescription;
        }

        public void setDmDescription(DescriptionDM dmDescription) {
            this.dmDescription = dmDescription;
        }
        public String toString(){
            return this.getCodeDME();
        }




    }
