package ma.uiass.eia.pds.Dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.StateAMB;

public class EtatAmbulanceDao implements IEtatAmbulanceDao{
    private EntityManager entityManager;

    public EtatAmbulanceDao(){
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<StateAMB> getAll() {
        return entityManager.createQuery("From EtatAmbulance", StateAMB.class).getResultList();
    }

    @Override
    public void add(StateAMB t) {
        EntityTransaction et = entityManager.getTransaction();
        try {
            et.begin();
            entityManager.persist(t);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public StateAMB getById(int id) {
        return entityManager.find(StateAMB.class, id);
    }
    
}
