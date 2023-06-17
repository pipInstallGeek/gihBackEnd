package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DemandeLit;
import ma.uiass.eia.pds.Model.EtatDemande;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public class DemandelitDao implements IDemandelitDao {

    private EntityManager entityManager;

    public DemandelitDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public void add(DemandeLit demandelit) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.persist(demandelit);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public DemandeLit getById(int id) {
        return null;
    }

    @Override
    public void delete(DemandeLit o) {

    }

    @Override
    public List<DemandeLit> getAll() {
        TypedQuery<DemandeLit> query = entityManager.createQuery("SELECT l FROM DemandeLit l ", DemandeLit.class);
        return query.getResultList();
    }
    @Override
    public List<DemandeLit> getAllByService(Service service) {
        TypedQuery<DemandeLit> query = entityManager.createQuery("SELECT l FROM DemandeLit l WHERE l.service= :service ", DemandeLit.class);
        query.setParameter("service", service);
        try {
            return query.getResultList();
        } catch (NonUniqueResultException e) {
            return null;
        }    }

    @Override
    public DemandeLit findByCode(String code) {
        TypedQuery<DemandeLit> query = entityManager.createQuery("SELECT l FROM DemandeLit l WHERE l.code = :code", DemandeLit.class);
        query.setParameter("code", code);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

    @Override
    public void updateT(DemandeLit DemandeLit) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            DemandeLit demandeUpdate = findByCode(DemandeLit.getCode());
            DemandeLit.setEtat(EtatDemande.ACCEPTEE);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void updateR(DemandeLit DemandeLit) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            DemandeLit demandeUpdate = findByCode(DemandeLit.getCode());
            DemandeLit.setEtat(EtatDemande.REJETEE);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
