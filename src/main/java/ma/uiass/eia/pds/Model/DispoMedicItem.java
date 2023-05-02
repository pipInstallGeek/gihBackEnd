package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "TDispoMedicItem")
public class DispoMedicItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeDispoMedicItem;

    @Column
    private String referenceItem;


    @ManyToOne
    @JoinColumn(name = "idDispoMedical", referencedColumnName = "idDispoMedical")
    private DispoMedical dispoMedical;

    @ManyToOne
    @JoinColumn(name = "idEspaceItem", referencedColumnName = "idEspace")
    private Espace espaceItem;


    public int getCodeDispoMedicItem() {
        return codeDispoMedicItem;
    }

    public void setCodeDispoMedicItem(int codeDispoMedicItem) {
        this.codeDispoMedicItem = codeDispoMedicItem;
    }

    public String getReferenceItem() {
        return referenceItem;
    }

    public void setReferenceItem(String referenceItem) {
        this.referenceItem = referenceItem;
    }

    public DispoMedical getDispoMedical() {
        return dispoMedical;
    }

    public void setDispoMedical(DispoMedical dispoMedical) {
        this.dispoMedical = dispoMedical;
    }

    public Espace getEspaceItem() {
        return espaceItem;
    }

    public void setEspaceItem(Espace espaceItem) {
        this.espaceItem = espaceItem;
    }

    public DispoMedicItem(String referenceItem, DispoMedical dispoMedical, Espace espace){
        setDispoMedical(dispoMedical);
        setReferenceItem(referenceItem);
        setEspaceItem(espace);
    }
    public DispoMedicItem(){}

    public String toString(){
      return this.getReferenceItem();}
}
