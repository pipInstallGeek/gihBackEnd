package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DetailsDemande;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;

import java.util.List;

public class DetailsDemandeDao implements IDetailsdemandeDao {

    private EntityManager entityManager;
    public DetailsDemandeDao(){ this.entityManager = HibernateUtil.getEntityManger();}
    @Override
    public List<DetailsDemande> getAll() {
        return entityManager.createQuery("From DetailsDemande ",DetailsDemande.class).getResultList();
    }

    @Override
    public void add(DetailsDemande detailsDemande) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(detailsDemande);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public DetailsDemande getById(int idDetailsDemande) {
        DetailsDemande detailsDemande= entityManager.find(DetailsDemande.class, idDetailsDemande);
        if(detailsDemande== null){
            System.out.println("Not found");
            return null;
        }
        return detailsDemande;
    }
}
