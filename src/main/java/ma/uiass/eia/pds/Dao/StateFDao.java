package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.*;

import java.util.List;

public class StateFDao implements IStateAMBDao<StateF> {
    private EntityManager entityManager;
    public StateFDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<StateF> getAll() {
        return entityManager.createQuery("from StateF ", StateF.class).getResultList();
    }

    @Override
    public void add(StateF stateF) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(stateF);
            stateF.setCodeState("F-"+stateF.getIdState());
            entityManager.merge(stateF);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public StateF getById(int id) {
        return entityManager.find(StateF.class, id);    }
    @Override
    public StateAMB findbyNom(String nomState) {
        TypedQuery<StateF> query = entityManager.createQuery("SELECT c FROM StateF c WHERE c.nomState = :nomState", StateF.class);
        query.setParameter("nomState", nomState);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

}
