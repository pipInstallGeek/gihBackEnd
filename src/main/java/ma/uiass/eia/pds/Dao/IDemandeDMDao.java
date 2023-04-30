package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DemandeDM;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public interface IDemandeDMDao {
    void add(DemandeDM demandeDM);

    void delete(DemandeDM o);

    List<DemandeDM> getAll();


    List<DemandeDM> getAllByService(Service service);

    DemandeDM findByCode(String code);

    void updateT(DemandeDM demandedm);

    void updateR(DemandeDM demandedm);
}
