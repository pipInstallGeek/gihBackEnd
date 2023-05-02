package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DispoMedical;
import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public class DispoMedicalDao implements IDispoMedicalDao {


    private final EntityManager entityManager;

    public DispoMedicalDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<DispoMedical> getAll() {
        return entityManager.createQuery("From DispoMedical", DispoMedical.class).getResultList();
    }

    @Override
    public void add(DispoMedical dispoMedical) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(dispoMedical);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public DispoMedical getById(int id) {
        DispoMedical dispoMedical = entityManager.find(DispoMedical.class, id);
        if(dispoMedical == null){
            System.out.println("Not found");
            return null;
        }
        return dispoMedical;
    }




}
