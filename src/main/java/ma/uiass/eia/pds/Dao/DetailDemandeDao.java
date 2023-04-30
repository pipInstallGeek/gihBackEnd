package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Demande;
import ma.uiass.eia.pds.Model.DetailDemande;

import java.util.List;

public class DetailDemandeDao implements IDetailDemandeDao {
    private final EntityManager em;
    public DetailDemandeDao(){
        em =  HibernateUtil.getEntityManger();
    }


    @Override
    public void add(DetailDemande detailDemande) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.persist(detailDemande);
            detailDemande.setCode("D"+detailDemande.getDM()+detailDemande.getDetail_id());
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }



    @Override
    public void delete(DetailDemande o) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.remove(o);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public DetailDemande findById(int id) {
        return null;
    }

    @Override
    public List<DetailDemande> getAll() {
        TypedQuery<DetailDemande> query = em.createQuery("SELECT l FROM DetailDemande l ", DetailDemande.class);
        return query.getResultList();
    }



    @Override
    public void update(DetailDemande d, Demande dem) {
        EntityTransaction et = null;
        d.setDemande(dem);
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.merge(d);
            et.commit();
        }catch(Exception e){
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public DetailDemande findByCode(String code) {
        TypedQuery<DetailDemande> query = em.createQuery("FROM DetailDemande WHERE code = :nom", DetailDemande.class);
        query.setParameter("nom", code);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
}
