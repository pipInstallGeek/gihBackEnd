package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.Service;
import ma.uiass.eia.pds.Model.TypeDM;

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
    public Service findbyNom(String nomService) {
        TypedQuery<Service> query = entityManager.createQuery("SELECT t FROM Service t WHERE t.nomService = :nomService", Service.class);
        query.setParameter("nomService", nomService);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // or throw a custom exception or handle the case accordingly
        }
    }




}

