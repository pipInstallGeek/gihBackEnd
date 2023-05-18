package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.StateAMB;

import java.util.List;

public class AmbulanceDao implements IAmbulanceDao{
    private EntityManager entityManager;
    public AmbulanceDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Ambulance> getAll() {
        return entityManager.createQuery(" from Ambulance ").getResultList();
    }
    @Override
    public void add(Ambulance a) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(a);
            a.setCodeAmbulance("AMB-"+a.getIdAmbulance());
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
    @Override
    public Ambulance getById(int id) {return entityManager.find(Ambulance.class, id);}
    @Override
    public Ambulance findbyCode(String codeAmbulance) {
        TypedQuery<Ambulance> query = entityManager.createQuery("SELECT a FROM Ambulance a WHERE a.codeAmbulance = :codeAmbulance", Ambulance.class);
        query.setParameter("codeAmbulance",codeAmbulance);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
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
    public void updateS(Ambulance a,double kilo) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            a.setKilométrage(kilo);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
