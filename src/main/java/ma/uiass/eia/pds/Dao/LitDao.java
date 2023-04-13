package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.EtatLit;
import ma.uiass.eia.pds.Model.Lit;

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
    public Long countOccupation(boolean occupation) {
        Long mycount = entityManager.createQuery("SELECT count(*) from Lit t where t.occupe = :value ", Long.class)
                .setParameter("value", occupation)
                .getSingleResult();
        return mycount;
    }


    @Override
    public void deleteLit(Lit lit) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(lit);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Lit lit, boolean occupee, Espace espace, EtatLit etatLit) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            lit.setOccupe(occupee);
            lit.setEspace(espace);
            lit.setEtatLit(etatLit);
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
    public Long countOccupationInEspace(Espace espace,boolean occupation) {
        Long mycount = entityManager.createQuery("SELECT count(*) from Lit t JOIN t.espace where t.occupe = :value and espace.idEspace = :value2 ", Long.class)
                .setParameter("value", occupation)
                .setParameter("value2", espace.getIdEspace())
                .getSingleResult();
        return mycount;
    }

    public List<Lit> test(int idMarque){
        return  entityManager.createQuery("from Lit t JOIN t.espace  where espace.idEspace =: value")
                .setParameter("value", idMarque).getResultList();
    }
}
