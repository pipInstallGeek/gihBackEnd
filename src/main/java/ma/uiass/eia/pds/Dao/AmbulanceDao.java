package ma.uiass.eia.pds.Dao;

import java.util.List;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Ambulance;

public class AmbulanceDao implements IAmbulanceDao {
    private final EntityManager entityManager;

    public AmbulanceDao(){
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<Ambulance> getAll() {
        return entityManager.createQuery("From Ambulance", Ambulance.class).getResultList();
    }

    @Override
    public void add(Ambulance ambulance) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(ambulance);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Ambulance getById(int id) {
        return entityManager.find(Ambulance.class, id);
    }

    @Override
    public void delete(Ambulance ambulance) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(ambulance);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Ambulance ambulance) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(ambulance);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
