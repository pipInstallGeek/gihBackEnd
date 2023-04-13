package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DemandeL;
import ma.uiass.eia.pds.Model.DetailDemandeL;
import ma.uiass.eia.pds.Model.EtatDemandeL;

import java.util.List;

public class DemandeLDao implements IDemandeLDao{
    private EntityManager entityManager ;
    public DemandeLDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<DemandeL> getAll() {return entityManager.createQuery("from DemandeL ", DemandeL.class).getResultList();}

    @Override
    public void add(DemandeL demandeL) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(demandeL);
            entityManager.merge(demandeL);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
@Override
    public void deleteLit(DemandeL demandeL) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(demandeL);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public DemandeL getById(int id) {
        DemandeL demandeL = entityManager.find(DemandeL.class, id);
        if(demandeL == null){
            System.out.println("Not found");
            return null;
        }
        return demandeL;
    }



    @Override
    public DemandeL findByCode(String codeD) {
        TypedQuery<DemandeL> query = entityManager.createQuery("FROM DemandeL WHERE codeDemandeL = :nom", DemandeL.class);
        query.setParameter("nom", codeD);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
    @Override
    public List<DemandeL> findByServie(int id) {
        TypedQuery<DemandeL> query = entityManager.createQuery("FROM DemandeL WHERE idService = :nom", DemandeL.class);
        query.setParameter("nom", id);
        try {
            return query.getResultList();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
    @Override
    public void updateEtat(DemandeL d, EtatDemandeL etat) {
        EntityTransaction et = null;
        d.setEtat(etat);
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



}}
