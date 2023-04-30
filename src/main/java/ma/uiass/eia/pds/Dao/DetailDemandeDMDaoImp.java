package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DemandeDM;
import ma.uiass.eia.pds.Model.DetailDemandeDM;

import java.util.List;

public class DetailDemandeDMDaoImp implements IDaoDetailDemandeDM {
    private EntityManager entityManager;

    public DetailDemandeDMDaoImp() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public void add(DetailDemandeDM detailDemandeDM) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.persist(detailDemandeDM);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }
    public List<DetailDemandeDM> findByidDemande(int code) {
        TypedQuery<DetailDemandeDM> query = entityManager.createQuery("FROM DetailDemandeDM WHERE demandeDM.id = :nom", DetailDemandeDM.class);
        query.setParameter("nom", code);
        try {
            return query.getResultList();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

    /*public List<DetailDemandeDM>findByDemande(int code){
        TypedQuery<DetailDemandeDM> query = entityManager.createQuery("FROM DetailDemandeDM  WHERE  =:nom",DetailDemandeDM.class);
        query.setParameter("nom",code);
        try{
            return query.getResultList();
        }catch (NonUniqueResultException e){
            return null;
        }
    }*/

    @Override
    public void delete(DetailDemandeDM o) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.remove(o);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List<DetailDemandeDM> getAll() {
        TypedQuery<DetailDemandeDM> query = entityManager.createQuery("SELECT l FROM DetailDemandeDM l ", DetailDemandeDM.class);
        return query.getResultList();
    }

    @Override
    public DetailDemandeDM findByCode(String code) {
        TypedQuery<DetailDemandeDM> query = entityManager.createQuery("FROM DetailDemandeDM WHERE code = :nom", DetailDemandeDM.class);
        query.setParameter("nom", code);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

    @Override
    public void update(DetailDemandeDM d, DemandeDM dem) {
        EntityTransaction et = null;
        d.setDemandeDM(dem);
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.merge(d);
            et.commit();
        }catch(Exception e){
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void updateqt(DetailDemandeDM d, int q) {
        EntityTransaction et = null;
        d.setQuantite(q);
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.merge(d);
            et.commit();
        }catch(Exception e){
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }
}
