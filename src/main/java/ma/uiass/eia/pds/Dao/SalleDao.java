package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Salle;

import java.util.List;

public class SalleDao implements IEspaceDao<Salle> {
    EntityManager entityManager;
    public SalleDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Salle> getAll() {
        return entityManager.createQuery(" from Salle  ", Salle.class).getResultList();
    }

    @Override
    public void add(Salle salle) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(salle);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Salle getById(int id) {
        return entityManager.find(Salle.class, id);
    }

    @Override
    public void update(Salle salle) {

    }
}
