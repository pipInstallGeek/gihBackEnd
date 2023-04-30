package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Demande;
import ma.uiass.eia.pds.Model.EtatDemande;

import java.util.List;

public class DemandeDao implements IDemandeDao {

    private EntityManager entityManager;

    public DemandeDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<Demande> getAll() {
        return entityManager.createQuery("from Demande ", Demande.class).getResultList();
    }

    @Override
    public void add(Demande demande) {
        EntityTransaction et = entityManager.getTransaction();
        try {
            et.begin();
            entityManager.persist(demande);
            demande.setNumDemande("DDM"+demande.getIdDemande());

            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Demande getById(int idDemande) {

        return entityManager.find(Demande.class, idDemande);
    }

    @Override
    public void update(Demande demande) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Demande demandeUpdate = getbycode(demande.getNumDemande());
            demande.setEtat(EtatDemande.Acceptée);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void updateR(Demande demande) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Demande demandeUpdate = getbycode(demande.getNumDemande());
            demande.setEtat(EtatDemande.Rejetée);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void update3(Demande demande) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Demande demandeUpdate = getbycode(demande.getNumDemande());
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCommande(Demande demande) {
        EntityTransaction et = null;
        try {
            et= entityManager.getTransaction();
            if(!et.isActive()){
                et.begin();
            }
            entityManager.remove(demande);
            et.commit();
        }catch (Exception e){
            if(et!=null){
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Demande getbycode(String codeC) {
        TypedQuery<Demande> query=entityManager.createQuery("FROM Demande  where numDemande= :num", Demande.class);
        query.setParameter("num",codeC);
        try{
            return query.getSingleResult();
        }catch (NonUniqueResultException e){
            return null;
    }
}



}
