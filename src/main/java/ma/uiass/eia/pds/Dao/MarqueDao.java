package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Marque;

import java.util.List;

public class MarqueDao implements IMarqueDao{
    private EntityManager entityManager;
    public MarqueDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Marque> getAll() {
        return entityManager.createQuery("from Marque", Marque.class).getResultList();
    }

    @Override
    public void add(Marque marque) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(marque);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Marque getById(int id) {
        return entityManager.find(Marque.class, id);
    }
}