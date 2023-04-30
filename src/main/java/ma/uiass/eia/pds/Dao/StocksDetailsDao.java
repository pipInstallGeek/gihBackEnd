package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DispositifMedical;
import ma.uiass.eia.pds.Model.StocksDetails;

import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            entityManager.persist(stocksDetails);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
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
            entityManager.merge(stocksDetails);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public StocksDetails getByDispoMedical(DispositifMedical dispositifMedical) {

        return entityManager.createQuery("from StocksDetails s join DispositifMedical where s.dispositifMedical =: value", StocksDetails.class)
                .setParameter("value", dispositifMedical)
                .getSingleResult();
    }
}
