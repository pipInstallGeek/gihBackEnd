package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.StocksDetails;

import java.util.ArrayList;
import java.util.List;

public class StocksDetailsDao implements IStocksDetailsDao {
    private final EntityManager entityManager;

    public StocksDetailsDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<StocksDetails> getAll() {
        return entityManager.createQuery("from StocksDetails ").getResultList();
    }

    @Override
    public void add(StocksDetails stocksDetails) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.persist(stocksDetails);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public StocksDetails getById(int id) {
        return entityManager.find(StocksDetails.class, id);
    }

    @Override
    public List getByStock(int id) {
        List<StocksDetails> stocksDetails = entityManager.createQuery("from StocksDetails ").getResultList();
        List<StocksDetails> stocksDetailsList = new ArrayList<>();
        stocksDetails.forEach(stocksDetail -> {
            if (stocksDetail.getStock().getIdStock() == id){
                stocksDetailsList.add(stocksDetail);
            }
        });
        return stocksDetailsList;
    }

    @Override
    public void mergeDetail(StocksDetails stocksDetails) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            StocksDetails stocksDetails1 = getById(stocksDetails.getIdStocksDetails());
            stocksDetails.setQuantity(stocksDetails1.getQuantity()+stocksDetails.getQuantity());
            entityManager.merge(stocksDetails);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /*#########################################################################################*/
    @Override
    public StocksDetails findByCode(int idStocksDetails) {
        TypedQuery<StocksDetails> query = entityManager.createQuery("FROM StocksDetails WHERE idStocksDetails = :idStocksDetails", StocksDetails.class);
        query.setParameter("idStocksDetails", idStocksDetails);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
    @Override
    public void updateqt(StocksDetails d, int q) {
        EntityTransaction et = null;
        d.setQuantity(q);
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.merge(d);
            et.commit();
        }catch(Exception e){
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }


}
