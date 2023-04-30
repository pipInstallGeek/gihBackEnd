package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "stock")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStock;
    @Column
    private String nomStock;

    @OneToOne(optional = true)
    @JoinColumn(name = "idService")
    private Service service;

    @OneToMany(mappedBy = "stock")
    private List<StocksDetails> stocksDetails;
    public String getNomStock() {
        return nomStock;
    }

    public void setNomStock(String nomStock) {
        this.nomStock = nomStock;
    }


    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getIdStock() {
        return idStock;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<StocksDetails> getStocksDetails() {
        return stocksDetails;
    }

    public void setStocksDetails(List<StocksDetails> stocksDetails) {
        this.stocksDetails = stocksDetails;
    }


    public Stock( String nomStock, Service service){
        setNomStock(nomStock);
        setService(service);
    }
    public Stock(){

    }

    @Override
    public String toString() {
        return  nomStock ;
    }
}