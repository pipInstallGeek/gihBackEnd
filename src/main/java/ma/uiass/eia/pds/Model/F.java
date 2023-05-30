package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

@Entity(name = "TFonctionnel")
@DiscriminatorValue("f")
public class F extends EtatsAmbulance{
    @Enumerated(EnumType.STRING)
    private final StateName stateName = StateName.F;
    private static double q;

    public F() {
    }

    public static double getQ() {
        return q;
    }

    public static void setQ(double q) {
        F.q = q;
    }

}
