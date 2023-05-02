package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.*;


import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "stock")
@Data
@NoArgsConstructor
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStock;
    @Column
    private String nomStock;

    @OneToOne(optional = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idService")
    private Service service;

    @OneToMany(mappedBy = "stock")
    @JsonIgnore
    private List<StocksDetails> stocksDetails;

    public Stock(String nomStock, Service service){
        setNomStock(nomStock);
        setService(service);
    }


    @Override
    public String toString() {
        return  nomStock ;
    }
}
