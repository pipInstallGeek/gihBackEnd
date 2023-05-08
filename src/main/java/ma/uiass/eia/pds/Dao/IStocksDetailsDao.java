package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.*;

import java.util.List;

public interface IStocksDetailsDao extends IDao<StocksDetails> {
    List<StocksDetails> getByStock(int idstock);

    void mergeDetail(StocksDetails stocksDetails);

    StocksDetails getByDispoMedical(DispositifMedical dispositifMedical);

    StocksDetails findByCode(int id);

    void updateqt(StocksDetails d, int q);


    void addDetailStock(StocksDetails stockD);

    List getIdByStock(int id);

    int getDeviceStockQuantity(String nomDM, Service service);

    StocksDetails getStockDetailsByNomDMAndService(String nomDM, String nomService);
}
