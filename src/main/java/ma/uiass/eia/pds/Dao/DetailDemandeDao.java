package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DemandeL;
import ma.uiass.eia.pds.Model.DetailDemandeL;

import java.util.List;


public class DetailDemandeDao implements IDao<DetailDemandeL> {
    private EntityManager entityManager;

    public DetailDemandeDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<DetailDemandeL> getAll() {
        return entityManager.createQuery("from DetailDemandeL", DetailDemandeL.class).getResultList();
    }


    @Override
    public void add(DetailDemandeL detailDemandeL) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(detailDemandeL);
            entityManager.merge(detailDemandeL);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public DetailDemandeL getById(int id) {
        DetailDemandeL detailDemandeL = entityManager.find(DetailDemandeL.class, id);
        if (detailDemandeL == null) {
            System.out.println("Not found");
            return null;
        }
        return detailDemandeL;
    }

    public void update(DetailDemandeL d, DemandeL dem) {
        EntityTransaction et = null;
        d.setDemande(dem);
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.merge(d);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    public DetailDemandeL findByCode(String codeD) {
        TypedQuery<DetailDemandeL> query = entityManager.createQuery("FROM DetailDemandeL WHERE codeDetailDL = :nom", DetailDemandeL.class);
        query.setParameter("nom", codeD);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }


    }

    public void deleteLit(DetailDemandeL detailDemandeL) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(detailDemandeL);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
