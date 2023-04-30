package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
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

    /*#########################################################################################*/
    @Override
    public void addstock(Stock S) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.persist(S);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public Stock findStockByName(String nom){
        TypedQuery<Stock> query=entityManager.createQuery("From Stock WHERE nomStock=:nom",Stock.class);
        query.setParameter("nom",nom);
        try{
            return query.getSingleResult();
        }catch (NonUniqueResultException e){
            return null;
        }

    }

}
