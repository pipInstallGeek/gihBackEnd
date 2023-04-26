package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IStocksDetailsDao;
import ma.uiass.eia.pds.Dao.StocksDetailsDao;
import ma.uiass.eia.pds.Model.Stock;
import ma.uiass.eia.pds.Model.StocksDetails;

import java.util.List;

public class StocksDetailsService implements IStocksDetailsService {
    IStocksDetailsDao stocksDetailsDao = new StocksDetailsDao();
    @Override
    public void ajouter(StocksDetails stocksDetails) {
        stocksDetailsDao.add(stocksDetails);
    }

    @Override
    public List<StocksDetails> afficherTout() {
        return stocksDetailsDao.getAll();
    }

    @Override
    public StocksDetails trouverId(int id) {
        return stocksDetailsDao.getById(id);
    }

    @Override
    public List<StocksDetails> getByStock(int idStock) {
        return stocksDetailsDao.getByStock(idStock);
    }
}
