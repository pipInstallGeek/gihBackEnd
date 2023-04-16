package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "TDispoMedical")
public class DispoMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDispoMedical;

    @Column
    private String nomDispoMed;

    @Column
    private int quantiteStock;

    @ManyToOne
    @JoinColumn(name = "codeTypeDm", referencedColumnName = "codeTypeDm")
    private TypeDM typeDM;



    public int getIdDispoMedical() {
        return idDispoMedical;
    }

    public void setIdDispoMedical(int idDispoMedical) {
        this.idDispoMedical = idDispoMedical;
    }

    public String getNomDispoMed() {
        return nomDispoMed;
    }

    public void setNomDispoMed(String nomDispoMed) {
        this.nomDispoMed = nomDispoMed;
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


    public DispoMedical(String nomDispoMed, TypeDM typeDM,int quantiteStock){
        setNomDispoMed(nomDispoMed);
        setQuantiteStock(quantiteStock);
        setTypeDM(typeDM);
    }

    public DispoMedical(){}

    public String toString(){
        return this.getNomDispoMed();

    }
}
