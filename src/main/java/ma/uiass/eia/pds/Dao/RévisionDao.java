package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.*;

import java.util.List;

public class RévisionDao implements IRévisionDao{
    private EntityManager entityManager;
    public RévisionDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    IStateAMBDao stateAMBDao=new StateFDao();
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
    public List<Révision> findbyCde(String immatruculation) {
        TypedQuery<Révision> query = entityManager.createQuery("SELECT c FROM Révision c WHERE c.ambulance.immatruculation = :immatruculation", Révision.class);
        query.setParameter("immatruculation",immatruculation);
        try {
            return query.getResultList();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
    @Override
    public Révision findbyCode(String codeRévision) {
        TypedQuery<Révision> query = entityManager.createQuery("SELECT c FROM Révision c WHERE c.codeRévision = :codeRévision", Révision.class);
        query.setParameter("codeRévision", codeRévision);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
    @Override
    public void updateS(Révision r,String dateS) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
           r.setDateSortie(dateS);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void updateState(Révision r,String Newstate) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            r.getAmbulance().getState().setNomState(Newstate);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public List<Révision> findbyDateSNull(String immatruculation ) {
        TypedQuery<Révision> query = entityManager.createQuery("SELECT r FROM Révision r WHERE r.ambulance.immatruculation = :immatruculation AND r.dateSortie='     '", Révision.class);
        query.setParameter("immatruculation", immatruculation );
        try {
            return query.getResultList();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
}
