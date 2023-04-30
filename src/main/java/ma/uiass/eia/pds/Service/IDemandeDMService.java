package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DemandeDM;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public interface IDemandeDMService {
    void create(String code, String nomS);

    List<DemandeDM> getAll();


    List<DemandeDM> getAllByService(Service service);

    DemandeDM findBycode(String code);

    void modifierT(String code);

    void modifierR(String code);
}
