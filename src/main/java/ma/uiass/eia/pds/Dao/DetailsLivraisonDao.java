package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;

import java.util.List;

public class DetailsLivraisonDao implements IDetailsLivraisonDao{
    private final EntityManager entityManager;
    public DetailsLivraisonDao(){
        entityManager =  HibernateUtil.getEntityManger();
    }
    @Override
    public List<DetailsLivraison> getAll() {
        return entityManager.createQuery("From DetailsLivraison", DetailsLivraison.class).getResultList();
    }

    @Override
    public void add(DetailsLivraison detailsLivraison) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(detailsLivraison);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public DetailsLivraison getById(int id) {
        DetailsLivraison livraisonFournisseur = entityManager.find(DetailsLivraison.class, id);
        if(livraisonFournisseur == null){
            System.out.println("Not found");
            return null;
        }
        return livraisonFournisseur;
    }
}

