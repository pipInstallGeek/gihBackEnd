package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DescriptionDMDao;
import ma.uiass.eia.pds.Dao.IStocksDetailsDao;
import ma.uiass.eia.pds.Dao.StockDao;
import ma.uiass.eia.pds.Dao.StocksDetailsDao;
import ma.uiass.eia.pds.Model.StocksDetails;

import java.util.List;

public class StocksDetailsService implements IStocksDetailsService {
    IStocksDetailsDao stocksDetailsDao = new StocksDetailsDao();
    DescriptionDMDao ddm=new DescriptionDMDao();
    StockDao std=new StockDao();


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

    /*###################################################################################*/


    @Override
    public StocksDetails getByCode(int idStocksDetails){return stocksDetailsDao.findByCode(idStocksDetails);}

    @Override
    public void updateqtS(int idStocksDetails, int q){stocksDetailsDao.updateqt(stocksDetailsDao.findByCode(idStocksDetails),q);}

    @Override
    public void ajouterS(String dispositifMedical, String stock, int quantity) {
        StocksDetails s = new StocksDetails(ddm.searchByNom(dispositifMedical),std.findStockByName(stock),quantity);
        stocksDetailsDao.add(s);
    }
}
