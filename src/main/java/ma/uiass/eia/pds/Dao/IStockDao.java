package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Stock;

public interface IStockDao extends IDao<Stock> {


    void addstock(Stock S);

    Stock findStockByName(String nom);
}
