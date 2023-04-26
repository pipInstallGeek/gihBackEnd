package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Fournisseur;

import jakarta.persistence.EntityManager;
import java.util.List;

public class FournisseurDao implements IFournisseurDao{
    private final EntityManager entityManager;
    public FournisseurDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Fournisseur> getAll() {
        return entityManager.createQuery("from Fournisseur", Fournisseur.class).getResultList();
    }

    @Override
    public void add(Fournisseur fournisseur) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(fournisseur);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }    }

    @Override
    public Fournisseur getById(int id) {
        return entityManager.find(Fournisseur.class, id);
    }
}
