package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.DispositifMedical;
import ma.uiass.eia.pds.Model.Service;
import ma.uiass.eia.pds.Model.StocksDetails;

import java.util.List;

public class StocksDetailsService implements IStocksDetailsService {
    IStocksDetailsDao stocksDetailsDao = new StocksDetailsDao();
    DescriptionDMDao ddm=new DescriptionDMDao();
    StockDao std=new StockDao();
    IServiceDao serviceDao=new ServiceDao();


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
        stocksDetailsDao.addDetailStock(s);
    }
    @Override
    public int getDeviceStockQuantity(String nomDM, String nomService){
        Service service=serviceDao.findbyNom(nomService);
        return stocksDetailsDao.getDeviceStockQuantity(nomDM,service);
    }
    public StocksDetails getStockDetailsByNomDMAndService(String nomDM, String nomService){
        return stocksDetailsDao.getStockDetailsByNomDMAndService(nomDM,nomService);
    }
    @Override
    public void ajouterStock(String TypeDM,String DM, String stock, int quantity) {
        //List<DispositifMedical> disp=ddm.getDmByNomType(TypeDM);
        List<StocksDetails> stocks=stocksDetailsDao.getByStock(1);
        for (StocksDetails d:stocks){
            if(d.getDispositifMedical().getTypeDM().equals(TypeDM)){
                StocksDetails s = new StocksDetails(d.getDispositifMedical(),std.findStockByName("logistique"),0);
                stocksDetailsDao.addDetailStock(s);
            }
        }

    }
}
