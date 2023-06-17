package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DemandeLit;
import ma.uiass.eia.pds.Model.EtatDemande;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public interface IDemandelitService {
    void create(String code, String nomS);

    List<DemandeLit> getAll();

    List<DemandeLit> getAllByService(Service service);

    DemandeLit findBycode(String code);

    void modifierT(String code);

    void modifierR(String code);
}
