package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

@Entity(name = "TNonFonctionnelCourteDurée")
@DiscriminatorValue("nfcd")
public class NFCD extends EtatsAmbulance {
    private final StateName stateName = StateName.NFCD;
    public NFCD() {
    }
}
