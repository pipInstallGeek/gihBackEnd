package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ChambreDao;
import ma.uiass.eia.pds.Dao.IEspaceDao;
import ma.uiass.eia.pds.Dao.StockDao;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Stock;

import java.util.List;

public class StockService implements IEspaceService<Stock>{
    private IEspaceDao stockDao = new StockDao();

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
        return (Stock) stockDao.getById(id);
    }

    @Override
    public void retirerLit(Lit l) {
        stockDao.remove(l);
    }
}
