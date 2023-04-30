package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.StocksDetails;

import java.util.List;

public interface IStocksDetailsService extends IService<StocksDetails> {


    void ajouterS(String dispositifMedical, String stock, int quantity);

    List<StocksDetails> getByStock(int stock);


    StocksDetails getByCode(int idStocksDetails);

    void updateqtS(int idStocksDetails, int q);
}
