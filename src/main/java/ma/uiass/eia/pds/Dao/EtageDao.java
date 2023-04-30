package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Etage;

import java.util.List;

public class EtageDao implements IEtageDao{
    private EntityManager entityManager;

    public EtageDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Etage> getAll() {
        return entityManager.createQuery("from Etage", Etage.class).getResultList();
    }

    @Override
    public void add(Etage etage) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(etage);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Etage getById(int id) {
        return entityManager.find(Etage.class, id);
    }
}