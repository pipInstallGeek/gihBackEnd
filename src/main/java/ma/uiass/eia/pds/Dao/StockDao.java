package ma.uiass.eia.pds.Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Lit;
import  ma.uiass.eia.pds.Model.Stock;

import java.util.List;


public class StockDao  implements IEspaceDao<Stock>  {
    private EntityManager entityManager;
    public StockDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Stock> getAll() {
        return entityManager.createQuery("from Stock ", Stock.class).getResultList();
    }

    @Override
    public void add(Stock stock) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(stock);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public Stock getById(int idStock) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Stock response=(Stock) entityManager.find(Stock.class,idStock);
            transaction.commit();
            return response;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void remove(Lit l)  {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(l);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
