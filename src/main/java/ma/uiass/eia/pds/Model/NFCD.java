package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

@Entity(name = "TNonFonctionnelCourteDurée")
@DiscriminatorValue("nfcd")
public class NFCD extends EtatsAmbulance {
    @Enumerated(EnumType.STRING)
    private final StateName stateName = StateName.NFCD;
    public NFCD() {
    }
}
