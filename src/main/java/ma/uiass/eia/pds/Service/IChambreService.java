package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Chambre;
import java.util.*;

public interface IChambreService {
    List<Chambre> afficheChambres();
    void ajouterChambre(Chambre chambre);
    Chambre trouverChambre(int id);

}
