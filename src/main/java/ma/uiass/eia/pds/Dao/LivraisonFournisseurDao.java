package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;

import java.util.List;

public class LivraisonFournisseurDao implements ILivraisonDao{

    private final EntityManager entityManager;

    public LivraisonFournisseurDao() {
        this.entityManager = entityManager;
    }

    @Override
    public List<LivraisonFournisseur> getAll() {
        return entityManager.createQuery("From LivraisonFournisseur ",LivraisonFournisseur.class).getResultList();
    }

    @Override
    public void add(LivraisonFournisseur livraisonFournisseur) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(livraisonFournisseur);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public LivraisonFournisseur getById(int idLivraison) {
        LivraisonFournisseur livraisonFournisseur = entityManager.find(LivraisonFournisseur.class, idLivraison);
        if(livraisonFournisseur== null){
            System.out.println("Not found");
            return null;
        }
        return livraisonFournisseur;
    }
}
