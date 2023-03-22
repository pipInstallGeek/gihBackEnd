package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Batiment;

import java.util.List;

public class BatimentDao implements IBatimentDao{
    private EntityManager entityManager ;
    public BatimentDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Batiment> getAll() {
        return entityManager.createQuery("from Batiment ").getResultList();
    }

    @Override
    public void add(Batiment batiment) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(batiment);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Batiment getById(int id) {
        return entityManager.find(Batiment.class, id);
    }

}
