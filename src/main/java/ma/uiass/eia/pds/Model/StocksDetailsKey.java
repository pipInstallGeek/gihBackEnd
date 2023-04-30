package ma.uiass.eia.pds.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public  class StocksDetailsKey implements Serializable {
    @Column(name = "idStock")
    private int idStock;
    @Column(name = "idDispositifMedical")
    private int idDispositifMedical;

    public StocksDetailsKey(int idStock, int idDispositifMedical) {
        this.idStock = idStock;
        this.idDispositifMedical = idDispositifMedical;
    }


}
