package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.*;

import java.util.List;

public class DescriptionDMDao implements IDescriptionDMDao {
    private EntityManager entityManager;

    public DescriptionDMDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<DispositifMedical> getAll() {
        return entityManager.createQuery(" from DispositifMedical ").getResultList();
    }

    @Override
    public void add(DispositifMedical descriptionDM) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            descriptionDM.setCodeDM(descriptionDM.getNomDM().substring(0,3)+descriptionDM.getTypeDM().getIdTypeDM());
            //descriptionDM.setNomDM(descriptionDM.getNomDM()+descriptionDM.getEspace());

            entityManager.persist(descriptionDM);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void Create(DispositifMedical d){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            d.setCodeDM(d.getTypeDM().getCodeTypeDM().substring(0,3) + d.getNomDM().substring(0,3));
            entityManager.persist(d);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public DispositifMedical getById(int id) {
        return entityManager.find(DispositifMedical.class, id);
    }

    @Override
    public List<DispositifMedical> getDmByNomType(String nomType) {
        TypedQuery<DispositifMedical> query = entityManager.createQuery(
                "SELECT d FROM DispositifMedical d WHERE d.typeDM.nomType = :nomType", DispositifMedical.class);
        query.setParameter("nomType", nomType);
        return query.getResultList();
    }

    @Override
    public DispositifMedical findbyNom(String nomDM) {
        TypedQuery<DispositifMedical> query = entityManager.createQuery("SELECT t FROM DispositifMedical t WHERE t.nomDM = :nomDM", DispositifMedical.class);
        query.setParameter("nomDM", nomDM);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public int getQuantitéByDM(String nomDM) {
        TypedQuery<Integer> query = entityManager.createQuery("SELECT t.quantité FROM DispositifMedical t WHERE t.nomDM = :nomDM", Integer.class);
        query.setParameter("nomDM", nomDM);
        List<Integer> results = query.getResultList();
        if (results.isEmpty()) {
            // Handle the case where no result was found
            return 0;
        } else {
            return results.get(0);
        }
    }
    public void deleteDM(DispositifMedical d) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            Query query = entityManager.createQuery("DELETE FROM StocksDetails s WHERE s.dispositifMedical = :dm");
            query.setParameter("dm", d);
            query.executeUpdate();
            entityManager.remove(d);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }
    public void updateNomDM(DispositifMedical d, String newNomDM) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }

            if (d != null) {
                d.setNomDM(newNomDM);
                d.setCodeDM(d.getTypeDM().getCodeTypeDM().substring(0,3) + d.getNomDM().substring(0,3));

                entityManager.merge(d);
            }

            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void updateqt(DispositifMedical d, int q) {
        EntityTransaction et = null;
        d.setQuantité(q);
        try {
            et = entityManager.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.merge(d);
            et.commit();
        }catch(Exception e){
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }






    public  List<DispositifMedical> getAllByService(Service service) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            TypedQuery<DispositifMedical> query = entityManager.createQuery("SELECT d FROM DispositifMedical d WHERE d.espace.service = :service", DispositifMedical.class);
            query.setParameter("service", service);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public DispositifMedical searchByNom(String nom){
        TypedQuery<DispositifMedical> query = entityManager.createQuery("From DispositifMedical WHERE nomDM=:nom", DispositifMedical.class);
        query.setParameter("nom",nom);
        try{
            return query.getSingleResult();
        }catch (NonUniqueResultException e){
            return  null;
        }
    }
}
