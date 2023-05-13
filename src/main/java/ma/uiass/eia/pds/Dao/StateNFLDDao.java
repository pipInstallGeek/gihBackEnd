package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;

import ma.uiass.eia.pds.Model.StateF;
import ma.uiass.eia.pds.Model.StateNFLD;

import java.util.List;

public class StateNFLDDao implements IStateAMBDao<StateNFLD> {
    private EntityManager entityManager;
    public StateNFLDDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<StateNFLD> getAll() {
        return entityManager.createQuery("from StateNFLD ", StateNFLD.class).getResultList();
    }

    @Override
    public void add(StateNFLD stateF) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(stateF);
            stateF.setCodeState("NFLD-"+stateF.getIdState());
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
    public StateNFLD getById(int id) {
        return entityManager.find(StateNFLD.class, id);    }
}