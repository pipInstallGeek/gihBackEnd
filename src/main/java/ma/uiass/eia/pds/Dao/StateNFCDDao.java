package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Salle;
import ma.uiass.eia.pds.Model.StateAMB;
import ma.uiass.eia.pds.Model.StateF;
import ma.uiass.eia.pds.Model.StateNFCD;

import java.util.List;

public class StateNFCDDao implements IStateAMBDao<StateNFCD> {
    private EntityManager entityManager;
    public StateNFCDDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<StateNFCD> getAll() {
        return entityManager.createQuery("from StateNFCD ", StateNFCD.class).getResultList();
    }

    @Override
    public void add(StateNFCD stateF) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(stateF);
            stateF.setCodeState("NFCD"+stateF.getIdState());
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
    public StateNFCD getById(int id) {
        return entityManager.find(StateNFCD.class, id);    }

    @Override
    public StateAMB findbyNom(String nomState) {
        return null;
    }
}
