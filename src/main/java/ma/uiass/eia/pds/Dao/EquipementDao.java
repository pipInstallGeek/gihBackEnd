package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Equipement;


import java.util.List;

public class  EquipementDao implements IEquipementDao {

    private EntityManager entityManager;

    public  EquipementDao() {
        entityManager = HibernateUtil.getEntityManger();
    }



    @Override
    public void add(Equipement equipement) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(equipement);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Equipement> getAll() {
        return  entityManager.createQuery("From Equipement ").getResultList();

    }
    @Override
    public Equipement getById(int id) {
        return entityManager.find(Equipement.class,id);
    }

}