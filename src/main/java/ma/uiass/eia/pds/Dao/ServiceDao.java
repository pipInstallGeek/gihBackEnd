package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public class ServiceDao implements IServiceDao{

    private  EntityManager entityManager;
    public ServiceDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Service> getAll() {
        return entityManager.createQuery("from Service", Service.class).getResultList();
    }

    @Override
    public void add(Service service) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(service);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Service getById(int idService) {
        Service service = entityManager.find(Service.class, idService);
        if(service == null){
            System.out.println("Not found");
            return null;
        }
        return service;
    }

    @Override
    public void update(Service service) {

    }
    public int getNombreLitOccupé(int serviceId) {
        String queryString = "SELECT COUNT(lit) FROM Lit lit " +
                "JOIN lit.espace espace " +
                "JOIN espace.service service " +
                "WHERE service.idService = :serviceId AND lit.occupe = true";
        TypedQuery<Long> query = entityManager.createQuery(queryString, Long.class);
        query.setParameter("serviceId", serviceId);
        Long result = query.getSingleResult();
        return result.intValue();
    }


}

