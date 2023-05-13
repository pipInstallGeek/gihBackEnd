package ma.uiass.eia.pds.Model;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name= "TStateF")
@Data
@DiscriminatorValue("stateF")
public class StateF extends StateAMB implements Serializable {
    @Column(name = "paraQ", length = 50)
    private double  paraQ;

    public StateF(String nomState) {
        super(nomState);
    }

    public StateF() {
        super();
    }

}
