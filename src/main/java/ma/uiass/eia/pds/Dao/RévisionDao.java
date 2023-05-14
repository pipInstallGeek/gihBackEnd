package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Révision;
import ma.uiass.eia.pds.Model.StateAMB;
import ma.uiass.eia.pds.Model.StateF;

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
    @Override
    public List<Révision> findbyCde(String codeAmbulance) {
        TypedQuery<Révision> query = entityManager.createQuery("SELECT c FROM Révision c WHERE c.ambulance.codeAmbulance = :codeAmbulance", Révision.class);
        query.setParameter("codeAmbulance", codeAmbulance);
        try {
            return query.getResultList();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
}
