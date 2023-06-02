package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

@Entity(name = "t_fonctionnel")
@DiscriminatorValue("1")

public class F extends EtatsAmbulance{
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

    @Override
    public String toString() {
        return "Fonctionnel" ;
    }
}