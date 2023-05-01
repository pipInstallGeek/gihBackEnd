package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DemandeDM;
import ma.uiass.eia.pds.Model.EtatDemande;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public class DemandeDMDaoImp implements IDemandeDMDao {
    private EntityManager entityManager;

    public DemandeDMDaoImp() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public void add(DemandeDM demandeDM) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.persist(demandeDM);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DemandeDM o) {

    }

    @Override
    public List<DemandeDM> getAll() {
        TypedQuery<DemandeDM> query = entityManager.createQuery("SELECT l FROM DemandeDM l ", DemandeDM.class);
        return query.getResultList();
    }
    @Override
    public List<DemandeDM> getAllByService(Service service) {
        TypedQuery<DemandeDM> query = entityManager.createQuery("SELECT l FROM DemandeDM l WHERE l.service= :service ", DemandeDM.class);
        query.setParameter("service", service);
        try {
            return query.getResultList();
        } catch (NonUniqueResultException e) {
            return null;
        }    }

    @Override
    public DemandeDM findByCode(String code) {
        TypedQuery<DemandeDM> query = entityManager.createQuery("SELECT l FROM DemandeDM l WHERE l.code = :code", DemandeDM.class);
        query.setParameter("code", code);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

    @Override
    public void updateT(DemandeDM demandedm) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            DemandeDM demandeUpdate = findByCode(demandedm.getCode());
            demandedm.setEtat(EtatDemande.ACCEPTEE);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void updateR(DemandeDM demandedm) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            DemandeDM demandeUpdate = findByCode(demandedm.getCode());
            demandedm.setEtat(EtatDemande.REJETEE);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
