package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Demande;

import java.util.List;

public class DemandeDao implements IDemandeDao{
    private EntityManager entityManager;
    public DemandeDao(){ this.entityManager = HibernateUtil.getEntityManger();}
    @Override
    public List<Demande> getAll() {
        return entityManager.createQuery("From Demande ",Demande.class).getResultList();
    }

    @Override
    public void add(Demande demande) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(demande);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Demande getById(int idDemande) {
        Demande demande= entityManager.find(Demande.class, idDemande);
        if(demande== null){
            System.out.println("Not found");
            return null;
        }
        return demande;
}}
