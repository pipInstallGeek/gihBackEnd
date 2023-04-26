package ma.uiass.eia.pds.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public  class StocksDetailsKey implements Serializable {
    @Column(name = "idStock")
    private int idStock;
    @Column(name = "idDispositifMedical")
    private int idDispositifMedical;

    public StocksDetailsKey(int idStock, int idDispositifMedical) {
        this.idStock = idStock;
        this.idDispositifMedical = idDispositifMedical;
    }

    public StocksDetailsKey() {

    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getIdDispositifMedical() {
        return idDispositifMedical;
    }

    public void setIdDispositifMedical(int idDispositifMedical) {
        this.idDispositifMedical = idDispositifMedical;
    }

}
