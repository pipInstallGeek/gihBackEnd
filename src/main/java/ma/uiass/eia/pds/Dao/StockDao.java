package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Stock;

import java.util.List;

public class StockDao implements IStockDao {
    private final EntityManager entityManager;

    public StockDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Stock> getAll() {
        return entityManager.createQuery("from Stock ").getResultList();
    }

    @Override
    public void add(Stock stock) {

    }

    @Override
    public Stock getById(int idStock) {
        Stock stock = entityManager.find(Stock.class, idStock);
        if(stock == null){
            System.out.println("Not found");
            return null;
        }
        return stock;    }
}
