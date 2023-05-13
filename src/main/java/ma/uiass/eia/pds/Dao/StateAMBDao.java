package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.StateAMB;

import java.util.List;

public class StateAMBDao implements IStateAMBDao<StateAMB> {
    private EntityManager entityManager;
    public StateAMBDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<StateAMB> getAll() {return entityManager.createQuery(" from EtatAmbulance ").getResultList();}

    @Override
    public void add(StateAMB h) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            h.setCodeState("Etat"+h.getNomState().substring(0,1)+h.getNomState().substring(4,4)+h.getNomState().substring(6,6));
            entityManager.persist(h);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public StateAMB getById(int id) {
        return entityManager.find(StateAMB.class, id);
    }
}
