package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

@Entity(name = "TNonFonctionnelCourteDurée")
@DiscriminatorValue("2")
public class NFCD extends EtatsAmbulance {
    private final StateName stateName = StateName.NFCD;
    public NFCD() {
    }
}
