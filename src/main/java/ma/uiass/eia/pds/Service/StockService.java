package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IStockDao;
import ma.uiass.eia.pds.Dao.StockDao;
import ma.uiass.eia.pds.Model.Stock;

import java.util.List;

public class StockService implements IStockService{
    IStockDao stockDao = new StockDao();
    @Override
    public void ajouter(Stock stock) {
        stockDao.add(stock);
    }

    @Override
    public List<Stock> afficherTout() {
        return stockDao.getAll();
    }

    @Override
    public Stock trouverId(int id) {
        return stockDao.getById(id);
    }
/*######################################################################*/

    @Override
    public Stock trouverNOM(String nom) {
        return stockDao.findStockByName(nom);
    }
}
