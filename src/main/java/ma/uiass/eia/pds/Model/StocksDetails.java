package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Table
@Data
@NoArgsConstructor
public class StocksDetails implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStocksDetails;
    @JoinColumn(name = "idDispositifMedical")
    @ManyToOne
    private DispositifMedical dispositifMedical;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "idStock", referencedColumnName = "idStock")
    private Stock stock;
    @Column
    private int quantity;

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

