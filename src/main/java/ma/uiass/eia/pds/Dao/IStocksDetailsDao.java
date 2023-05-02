package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DetailDemande;
import ma.uiass.eia.pds.Model.DispositifMedical;
import ma.uiass.eia.pds.Model.Stock;
import ma.uiass.eia.pds.Model.StocksDetails;

import java.util.List;

public interface IStocksDetailsDao extends IDao<StocksDetails> {
    List<StocksDetails> getByStock(int idstock);
    void mergeDetail(StocksDetails stocksDetails);
    StocksDetails getByDispoMedical(DispositifMedical dispositifMedical);

    StocksDetails findByCode(int id);

    void updateqt(StocksDetails d, int q);


    void addDetailStock(StocksDetails stockD);
}
