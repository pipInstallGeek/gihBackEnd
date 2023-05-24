package ma.uiass.eia.pds.Model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name= "TStateNFCD")
@Data
@DiscriminatorValue("stateNFCD")
public class StateNFCD extends StateAMB implements Serializable {
    public StateNFCD(String nomState) {
        super(nomState);
    }

    @Override
    public String toString() {
        return "NFCD";
    }

    public StateNFCD() {
        super();
    }


}