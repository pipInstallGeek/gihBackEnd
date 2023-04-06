package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Commande;
import ma.uiass.eia.pds.Model.EtatCommande;
import ma.uiass.eia.pds.Model.Marque;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CommandeDao implements ICommandeDao {

    private EntityManager entityManager;

    public CommandeDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<Commande> getAll() {
        return entityManager.createQuery("from Commande ", Commande.class).getResultList();
    }

    @Override
    public void add( Commande commande) {
        EntityTransaction et = entityManager.getTransaction();
        try {
            et.begin();
            entityManager.persist(commande);
            commande.setEtat(EtatCommande.EN_TRAITEMENT);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Commande getById(int idCommande) {

        return entityManager.find(Commande.class, idCommande);
    }

    @Override
    public void update(Commande commande) {
       EntityTransaction transaction = entityManager.getTransaction();
       try{
           transaction.begin();
           Commande commandeUpdate= getbycode(commande.getNumCommande());
           commande.setEtat(EtatCommande.TRAITEE);
           transaction.commit();
       }catch (Exception e){
           if(transaction!=null){
               transaction.rollback();
           }
           e.printStackTrace();
       }
    }

    @Override
    public void deleteCommande(Commande commande) {
        EntityTransaction et = null;
        try {
            et= entityManager.getTransaction();
            if(!et.isActive()){
                et.begin();
            }
            entityManager.remove(commande);
            et.commit();
        }catch (Exception e){
            if(et!=null){
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Commande getbycode(String codeC) {
        TypedQuery<Commande> query=entityManager.createQuery("FROM Commande  where numCommande= :num",Commande.class);
        query.setParameter("num",codeC);
        try{
            return query.getSingleResult();
        }catch (NonUniqueResultException e){
            return null;
        }
    }



}

