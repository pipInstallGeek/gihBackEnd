package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tespace")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Espace {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idEspace;


}
