package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

@Entity(name = "t_non_fonctionnel_longue_durée")
@DiscriminatorValue("3")

public class NFLD extends EtatsAmbulance{
    private int id;
    private final StateName stateName = StateName.NFLD;
    public NFLD() {
        super();
    }

    @Override
    public String toString() {
        return "Non fonctionel longue durée" ;
    }
}
