package ma.uiass.eia.pds.Model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name= "TStateNFLD")
@Data
@DiscriminatorValue("stateNFLD")
public class StateNFLD extends StateAMB implements Serializable {
    public StateNFLD(String nomState) {
        super(nomState);
    }

    @Override
    public String toString() {
        return "NCLD";
    }

    public StateNFLD() {
        super();
    }


}