package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.StocksDetails;

import java.util.List;

public interface IStocksDetailsDao extends IDao<StocksDetails> {
    List<StocksDetails> getByStock(int idstock);
    void mergeDetail(StocksDetails stocksDetails);

    /*#########################################################################################*/

    StocksDetails findByCode(int id);

    void updateqt(StocksDetails d, int q);
}
