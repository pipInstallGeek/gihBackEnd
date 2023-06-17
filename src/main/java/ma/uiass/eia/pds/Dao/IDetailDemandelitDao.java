package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DemandeLit;
import ma.uiass.eia.pds.Model.DemandeLitFormat;
import ma.uiass.eia.pds.Model.DetailDemandeLit;

import java.util.List;

public interface IDetailDemandelitDao {
    void add(DetailDemandeLit DetailDemandeLit);

    void delete(DetailDemandeLit o);

    List<DetailDemandeLit> getAll();

    DetailDemandeLit findByCode(String code);

    void update(DetailDemandeLit d, DemandeLit dem);

    void updateqt(DetailDemandeLit d, int q);
}