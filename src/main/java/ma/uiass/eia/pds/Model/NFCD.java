package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

@Entity(name = "t_non_fonctionnel_courte_durée")
@DiscriminatorValue("2")
public class NFCD extends EtatsAmbulance {
    private final StateName stateName = StateName.NFCD;

    public NFCD() {
    }

    @Override
    public String toString() {
        return "Non Fonctionel courte durée" ;
    }
}

