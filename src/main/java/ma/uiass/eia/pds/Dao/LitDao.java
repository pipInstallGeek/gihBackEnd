package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.EtatLit;
import ma.uiass.eia.pds.Model.Lit;

import java.util.List;
import java.util.stream.Collectors;

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
    public void update(Lit lit) {

    }

    /*public List<Lit> getAvailableLit() {
        List<Lit> lits = entityManager.createQuery("select r from Lit r ", Lit.class).getResultList();
        List<Lit> litsDisponiblesEtEnBonEtat = lits.stream()
                .filter(lit -> lit.getOccupe() == false && lit.getEtatLit() == EtatLit.BONNNEETAT)
                .collect(Collectors.toList());

        return litsDisponiblesEtEnBonEtat;
    }*/
    public List<Lit> getAvailableLit(String nomService, String typeEspace) {
        return entityManager.createQuery(
                        "SELECT l FROM Lit l JOIN l.espace e WHERE e.service.nomService = :nomService " +
                                "AND e.typeEspace = :typeEspace AND l.occupe = false AND l.etatLit = :etatLit",
                        Lit.class)
                .setParameter("nomService", nomService)
                .setParameter("typeEspace", typeEspace)
                .setParameter("etatLit", EtatLit.BONNNEETAT)
                .getResultList();
    }

        //return lits.stream().map(Lit::getIdLit).collect(Collectors.toList());
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
}
