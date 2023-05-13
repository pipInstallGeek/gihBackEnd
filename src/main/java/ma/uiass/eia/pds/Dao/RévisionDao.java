package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Révision;

import java.util.List;

public class RévisionDao implements IRévisionDao{
    private EntityManager entityManager;
    public RévisionDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Révision> getAll() {
        return entityManager.createQuery(" from Révision ").getResultList();
    }

    @Override
    public void add(Révision r) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(r);
            r.setCodeRévision("REV-"+r.getIdRévision());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
    @Override
    public Révision getById(int id) {
        return entityManager.find(Révision.class, id);
    }
}
