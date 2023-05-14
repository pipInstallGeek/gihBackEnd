package ma.uiass.eia.pds.Dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.EtatAmbulance;

public class EtatAmbulanceDao implements IEtatAmbulanceDao{
    private EntityManager entityManager;

    public EtatAmbulanceDao(){
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<EtatAmbulance> getAll() {
        return entityManager.createQuery("From EtatAmbulance", EtatAmbulance.class).getResultList();
    }

    @Override
    public void add(EtatAmbulance t) {
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
    public EtatAmbulance getById(int id) {
        return entityManager.find(EtatAmbulance.class, id);
    }
    
}
