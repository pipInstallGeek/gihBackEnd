package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Chambre;


import java.util.List;

public class ChambreDao implements IChambreDao {
    private EntityManager entityManager;
    public ChambreDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public void add(Chambre chambre) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(chambre);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Chambre> getAll() {
        return entityManager.createQuery("from Chambre ", Chambre.class).getResultList();
    }

    @Override
    public Chambre getById(int idChambre) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Chambre response=(Chambre) entityManager.find(Chambre.class,idChambre);
            transaction.commit();
            return response;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }


}
