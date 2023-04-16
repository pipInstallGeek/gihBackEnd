package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.Model.DetailsLivraison;

import java.util.List;

public class DetailsLivraisonDao implements IDetailsLivraisonDao{
    private EntityManager entityManager;

    public DetailsLivraisonDao () {
        this.entityManager = entityManager;
    }

    @Override
    public List< DetailsLivraison> getAll() {
        return entityManager.createQuery("From  DetailsLivraison ", DetailsLivraison.class).getResultList();
    }

    @Override
    public void add( DetailsLivraison detailsLivraison) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist( detailsLivraison);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public  DetailsLivraison getById(int idDetails) {
        DetailsLivraison detailsLivraison = entityManager.find( DetailsLivraison.class, idDetails);
        if( detailsLivraison == null){
            System.out.println("Not found");
            return null;
        }
        return detailsLivraison;
    }
}
