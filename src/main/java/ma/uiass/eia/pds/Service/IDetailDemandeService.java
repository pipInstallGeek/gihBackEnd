package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DetailDemande;

import java.util.List;

public interface IDetailDemandeService {

    void ajouter(String DM, int quantite);

    void supprimer(String codeDD);

    List<DetailDemande> afficherTout();

    void update(String codeDD, String codeD);

    DetailDemande trouverId(int id);
}
