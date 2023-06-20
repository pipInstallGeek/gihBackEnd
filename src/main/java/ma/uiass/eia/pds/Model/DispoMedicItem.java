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

    @Column
    private int nombreItems;

    @ManyToOne
    @JoinColumn(name = "idDispoMedical", referencedColumnName = "idDispoMedical")
    private DispoMedical dispoMedical;

  /*  @ManyToOne
    @JoinColumn(name = "idEspaceItem", referencedColumnName = "idEspace")
    private Espace espaceItem;
   */

    @Column
    private String espaceItem;


    public int getNombreItems() {
        return nombreItems;
    }

    public void setNombreItems(int nombreItems) {
        this.nombreItems = nombreItems;
    }

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

    public String getEspaceItem() {
        return espaceItem;
    }

    public void setEspaceItem(String espaceItem) {
        this.espaceItem = espaceItem;
    }

    public DispoMedicItem(String referenceItem, DispoMedical dispoMedical,String espace,int nombreItems){
        setDispoMedical(dispoMedical);
        setReferenceItem(referenceItem);
        setEspaceItem(espace);
        setNombreItems(nombreItems);
    }
    public DispoMedicItem(){}

    public String toString(){
      return this.getReferenceItem();}
}
