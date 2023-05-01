package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "stockdetails")
public class StocksDetails implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStocksDetails;

    public void setIdStocksDetails(int idStocksDetails) {
        this.idStocksDetails = idStocksDetails;
    }

    @ManyToOne
    @JoinColumn(name = "idDM")
    private DispositifMedical dispositifMedical;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idStock", referencedColumnName = "idStock")
    private Stock stock;
    @Column
    private int quantity;

    public int getIdStocksDetails() {
        return idStocksDetails;
    }

    public DispositifMedical getDispositifMedical() {
        return dispositifMedical;
    }

    public void setDispositifMedical(DispositifMedical dispositifMedical) {
        this.dispositifMedical = dispositifMedical;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public StocksDetails() {
    }

    public StocksDetails(DispositifMedical dispositifMedical, Stock stock, int quantity) {
        this.dispositifMedical = dispositifMedical;
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return
                "dispositifMedical=" + dispositifMedical+ " "+ stock+" "+ quantity ;
    }
}
