package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.EtatLit;
import ma.uiass.eia.pds.Model.Lit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

       /* public List<Lit> getAvailableLit(String nomService, String typeEspace) {
            return entityManager.createQuery(
                            "SELECT l FROM Lit l JOIN l.espace e WHERE e.service.nomService = :nomService " +
                                    "AND e.typeEspace = :typeEspace AND l.occupe = false AND l.etatLit = :etatLit",
                            Lit.class)
                    .setParameter("nomService", nomService)
                    .setParameter("typeEspace", typeEspace)
                    .setParameter("etatLit", EtatLit.BONNNEETAT)
                    .getResultList();
        }*/public List<Lit> getAvailableLit(String nomService) {
           return entityManager.createQuery(
                           "SELECT l FROM Lit l JOIN l.espace e WHERE e.service.nomService = :nomService " +
                                   "AND l.occupe = false AND l.etatLit = :etatLit", Lit.class)
                   .setParameter("nomService", nomService)
                   .setParameter("etatLit", EtatLit.BONNNEETAT)
                   .getResultList();
       }
            @Override
            public Lit findbyCode(String codeLit) {
                TypedQuery<Lit> query = entityManager.createQuery("FROM Lit l WHERE l.codeLit = :codeLit", Lit.class);
                query.setParameter("codeLit", codeLit);
                try {
                    return query.getSingleResult();
                } catch (NonUniqueResultException e) {
                    return null;
                }
            }



    public Map<String, Integer> getNLDB() {
            TypedQuery<Object[]> query = entityManager.createQuery(
                    "SELECT s.nomService, COUNT(*) AS count FROM Lit l " +
                            "JOIN l.espace e " +
                            "JOIN e.service s " +
                            "WHERE l.occupe = false " +
                            "GROUP BY s.nomService",
                    Object[].class
            );
            List<Object[]> results = query.getResultList();
            Map<String, Integer> nombresLitsDisponiblesPourServices = new HashMap<>();
            for (Object[] result : results) {
                String nomService = (String) result[0];
                int count = ((Number) result[1]).intValue();
                nombresLitsDisponiblesPourServices.put(nomService, count);
            }
            return nombresLitsDisponiblesPourServices;
        }
        public Map<String, Integer> getNLO() {
            TypedQuery<Object[]> query = entityManager.createQuery(
                    "SELECT s.nomService, COUNT(*) AS count FROM Lit l " +
                            "JOIN l.espace e " +
                            "JOIN e.service s " +
                            "WHERE l.occupe =true " +
                            "GROUP BY s.nomService",
                    Object[].class
            );
            List<Object[]> results = query.getResultList();
            Map<String, Integer> nombresLitsDisponiblesPourServices = new HashMap<>();
            for (Object[] result : results) {
                String nomService = (String) result[0];
                int count = ((Number) result[1]).intValue();
                nombresLitsDisponiblesPourServices.put(nomService, count);
            }
            return nombresLitsDisponiblesPourServices;
        }

    }
