package ma.uiass.eia.pds.Dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Fournisseur;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;

import java.util.List;

public class LivraisonFournisseurDao implements ILivraisonFoursnisseurDao{
    private EntityManager entityManager;

    public LivraisonFournisseurDao(){
        entityManager=HibernateUtil.getEntityManger();
    }

    @Override
    public List<LivraisonFournisseur> getAll() {
        return entityManager.createQuery("From LivraisonFournisseur", LivraisonFournisseur.class).getResultList();
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
    public LivraisonFournisseur getById(int id) {
        return entityManager.find(LivraisonFournisseur.class, id);
    }
}
