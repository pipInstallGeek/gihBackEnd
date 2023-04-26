package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Stock;
import ma.uiass.eia.pds.Model.StocksDetails;

import java.util.List;

public interface IStocksDetailsDao extends IDao<StocksDetails> {
    List<StocksDetails> getByStock(int idstock);
    void mergeDetail(StocksDetails stocksDetails);

}
