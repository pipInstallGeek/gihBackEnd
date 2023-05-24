package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.StateAMB;
import ma.uiass.eia.pds.Model.StateAMB;

import java.util.List;

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
    public Ambulance findbyCode(String immatruculation) {
        TypedQuery<Ambulance> query = entityManager.createQuery("SELECT a FROM Ambulance a WHERE a.immatruculation = :immatruculation", Ambulance.class);
        query.setParameter("immatruculation",immatruculation);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public void updateS(Ambulance a,double kilo) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            a.setKilometrage(kilo);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
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
    public void updateState(Ambulance ambulance, StateAMB newState) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
           ambulance.setState(newState);
            entityManager.merge(ambulance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
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
