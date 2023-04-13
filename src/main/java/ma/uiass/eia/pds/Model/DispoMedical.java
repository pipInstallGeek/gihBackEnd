package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "TDispoMedical")
public class DispoMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDispoMedical;

    @Column
    private String nameDispo;

    @Column
    private int quantiteStock;

    @OneToOne(mappedBy = "dispoMedical")
    private DetailsLivraison detailsLivraison;
    @ManyToOne
    @JoinColumn(name = "codeTypeDm", referencedColumnName = "codeTypeDm")
    private TypeDM typeDM;

    public int getIdDispoMedical() {
        return idDispoMedical;
    }

    public void setIdDispoMedical(int idDispoMedical) {
        this.idDispoMedical = idDispoMedical;
    }

    public String getNameDispo() {
        return nameDispo;
    }

    public void setNameDispo(String nameDispo) {
        this.nameDispo = nameDispo;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public TypeDM getTypeDM() {
        return typeDM;
    }

    public void setTypeDM(TypeDM typeDM) {
        this.typeDM = typeDM;
    }

    public DispoMedical(String nameDispo,int quantiteStock,TypeDM typeDM){
        setNameDispo(nameDispo);
        setQuantiteStock(quantiteStock);
        setTypeDM(typeDM);
    }

    public DispoMedical(TypeDM typeDM,int quantiteStock){
        setQuantiteStock(quantiteStock);
        setTypeDM(typeDM);
    }

    public String toString(){
        return this.getNameDispo();

    }
}
