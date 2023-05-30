package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

@Entity(name = "TNonFonctionnelLongueDurée")
@DiscriminatorValue("nfld")
public class NFLD extends EtatsAmbulance{
    private int id;
    @Enumerated(EnumType.STRING)
    private final StateName stateName = StateName.NFLD;
    public NFLD() {

    }
}