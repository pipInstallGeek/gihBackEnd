package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DemandeLit;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public interface IDemandelitDao extends IDao<DemandeLit> {


    void delete(DemandeLit o);

    List<DemandeLit> getAllByService(Service service);

    DemandeLit findByCode(String code);

    void updateT(DemandeLit DemandeLit);

    void updateR(DemandeLit DemandeLit);
}
