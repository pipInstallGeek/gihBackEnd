
package ma.uiass.eia.pds.Model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table
public class Revision {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRevision;

    @Column
    private LocalDate dateRevision;

    @ManyToOne
    @JoinColumn(name = "idAmbulance", referencedColumnName = "idAmbulance")
    private Ambulance ambulance;

    public Revision(LocalDate dateRevision){
        setDateRevision(dateRevision);
    }
}
