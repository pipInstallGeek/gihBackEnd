package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.EtatLit;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Reservation;

import java.util.Date;
import java.util.List;

public class LitDao implements ILitDao{

    private final EntityManager entityManager;
    public LitDao(){
        entityManager =  HibernateUtil.getEntityManger();
    }
    @Override
    public List<Lit> getAll() {
        return entityManager.createQuery("From Lit",Lit.class).getResultList();
    }

    @Override
    public void add(Lit lit) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(lit);
            lit.setCodeLit(lit.getEspace().getCodeEspace()+lit.getIdLit());
            entityManager.merge(lit);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Lit getById(int idLit) {
        Lit lit = entityManager.find(Lit.class, idLit);
        if(lit == null){
            System.out.println("Not found");
            return null;
        }
        return lit;
    }
    @Override
    public void addLitInStock(Lit lit) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(lit);
            lit.setEspace(null);
            lit.setEtatLit(EtatLit.BONNNEETAT);
            lit.setOccupe(Boolean.FALSE);
            entityManager.merge(lit);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public List<Lit> getAll2() {
        return entityManager.createQuery("select r from Lit r where espace=null and occupe=false ", Lit.class).getResultList();

    }

}
