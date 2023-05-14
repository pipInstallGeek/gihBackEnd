package ma.uiass.eia.pds.Dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Revision;
import ma.uiass.eia.pds.Model.Service;

public class RevisionDao implements IRevisionDao {
    private EntityManager entityManager;
    
    public RevisionDao(){
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public void add(Revision t) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(t);
           
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }        
    }

    @Override
    public List<Revision> getAll() {
    
        return entityManager.createQuery("From Revision", Revision.class).getResultList();
    }

    @Override
    public Revision getById(int id) {
        return entityManager.find(Revision.class, id);
    }

    
}
