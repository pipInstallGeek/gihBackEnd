package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DemandeLit;
import ma.uiass.eia.pds.Model.DetailDemandeLit;

import java.util.List;

public class DetailDemandelitDao implements IDetailDemandelitDao {
    private final EntityManager entityManager;
    public DetailDemandelitDao(){
        entityManager =  HibernateUtil.getEntityManger();
    }


    @Override
    public void add(DetailDemandeLit DetailDemandeLit) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.persist(DetailDemandeLit);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }
    public List<DetailDemandeLit> findByidDemande(int code) {
        TypedQuery<DetailDemandeLit> query = entityManager.createQuery("FROM DetailDemandeLit WHERE demandelit.id = :nom", DetailDemandeLit.class);
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
    public void delete(DetailDemandeLit o) {
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
    public List<DetailDemandeLit> getAll() {
        TypedQuery<DetailDemandeLit> query = entityManager.createQuery("SELECT l FROM DetailDemandeLit l ", DetailDemandeLit.class);
        return query.getResultList();
    }

    @Override
    public DetailDemandeLit findByCode(String code) {
        TypedQuery<DetailDemandeLit> query = entityManager.createQuery("FROM DetailDemandeLit WHERE code = :nom", DetailDemandeLit.class);
        query.setParameter("nom", code);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

    @Override
    public void update(DetailDemandeLit d, DemandeLit dem) {
        EntityTransaction et = null;
        d.setDemandelit(dem);
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
    public void updateqt(DetailDemandeLit d, int q) {
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
