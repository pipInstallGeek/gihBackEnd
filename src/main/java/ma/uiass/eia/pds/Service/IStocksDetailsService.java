package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Stock;
import ma.uiass.eia.pds.Model.StocksDetails;

import java.util.List;

public interface IStocksDetailsService extends IService<StocksDetails> {

    List<StocksDetails> getByStock(int stock);
}
