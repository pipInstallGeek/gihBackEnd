
package ma.uiass.eia.pds.Model.State;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
public abstract class EtatAmbulance{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtatAmbulance;

    @OneToMany(mappedBy = "etatAmbulance")
    private List<Ambulance> ambulances;

    @ManyToOne
    @JoinColumn(name = "idEtatHistory")
    private EtatHistory etatHistory;

   
}