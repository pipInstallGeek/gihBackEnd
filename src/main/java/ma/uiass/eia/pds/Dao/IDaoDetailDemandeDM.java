package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DemandeDM;
import ma.uiass.eia.pds.Model.DetailDemandeDM;

import java.util.List;

public interface IDaoDetailDemandeDM {
    void add(DetailDemandeDM detailDemandeDM);

    void delete(DetailDemandeDM o);

    List<DetailDemandeDM> getAll();

    DetailDemandeDM findByCode(String code);


    void update(DetailDemandeDM d, DemandeDM dem);

    void updateqt(DetailDemandeDM d, int q);
}
