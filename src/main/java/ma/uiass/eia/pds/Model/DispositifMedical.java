package ma.uiass.eia.pds.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TDispoMedical")
public class DispositifMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDispositifMedical;

    @Column
    private String nameDispositifMedical;


    @OneToMany(mappedBy = "dispositifMedical")
    @JsonIgnore
    private List<DetailsLivraison> detailsLivraison;
    @ManyToOne
    @JoinColumn(name = "idTypeDm", referencedColumnName = "idTypeDM")
    private TypeDM typeDM;
    @JsonIgnore
    @OneToMany(mappedBy = "dispositifMedical")
    private List<StocksDetails> stocksDetails;

    public int getIdDispositifMedical() {
        return idDispositifMedical;
    }

    public void setIdDispositifMedical(int idDispoMedical) {
        this.idDispositifMedical = idDispoMedical;
    }

    public String getNameDispositifMedical() {
        return nameDispositifMedical;
    }

    public void setNameDispositifMedical(String nameDispo) {
        this.nameDispositifMedical = nameDispo;
    }

    public TypeDM getTypeDM() {
        return typeDM;
    }

    public void setTypeDM(TypeDM typeDM) {
        this.typeDM = typeDM;
    }

    public List<DetailsLivraison> getDetailsLivraison() {
        return detailsLivraison;
    }

    public void setDetailsLivraison(List<DetailsLivraison> detailsLivraison) {
        this.detailsLivraison = detailsLivraison;
    }

    public List<StocksDetails> getStocksDetails() {
        return stocksDetails;
    }

    public void setStocksDetails(List<StocksDetails> stocksDetails) {
        this.stocksDetails = stocksDetails;
    }

    public DispositifMedical(String nameDispositifMedical, int quantiteStock, TypeDM typeDM){
        setNameDispositifMedical(nameDispositifMedical);
        setTypeDM(typeDM);
    }

    public DispositifMedical(){

    }

    public String toString(){
        return this.getNameDispositifMedical();

    }
}
