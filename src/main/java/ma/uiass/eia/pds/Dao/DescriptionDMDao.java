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
    public List<DescriptionDM> getAll() {
        return entityManager.createQuery(" from DescriptionDM ").getResultList();
    }

    @Override
    public void add(DescriptionDM descriptionDM) {
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
    public void Create(DescriptionDM d){
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
    public DescriptionDM getById(int id) {
        return entityManager.find(DescriptionDM.class, id);
    }

    @Override
    public List<DescriptionDM> getDmByNomType(String nomType) {
        TypedQuery<DescriptionDM> query = entityManager.createQuery(
                "SELECT d FROM DescriptionDM d WHERE d.typeDM.nomType = :nomType", DescriptionDM.class);
        query.setParameter("nomType", nomType);
        return query.getResultList();
    }

    @Override
    public DescriptionDM findbyNom(String nomDM) {
        TypedQuery<DescriptionDM> query = entityManager.createQuery("SELECT t FROM DescriptionDM t WHERE t.nomDM = :nomDM", DescriptionDM.class);
        query.setParameter("nomDM", nomDM);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public int getQuantitéByDM(String nomDM) {
        TypedQuery<Integer> query = entityManager.createQuery("SELECT t.quantité FROM DescriptionDM t WHERE t.nomDM = :nomDM", Integer.class);
        query.setParameter("nomDM", nomDM);
        List<Integer> results = query.getResultList();
        if (results.isEmpty()) {
            // Handle the case where no result was found
            return 0;
        } else {
            return results.get(0);
        }
    }
    @Override
    public void deleteDM(DescriptionDM d) {
        EntityTransaction et = null;
        try {
            et= entityManager.getTransaction();
            if(!et.isActive()){
                et.begin();
            }
            entityManager.remove(d);
            et.commit();
        }catch (Exception e){
            if(et!=null){
                et.rollback();
            }
            e.printStackTrace();
        }
    }
    public void updateNomDM(DescriptionDM d, String newNomDM) {
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






    public  List<DescriptionDM> getAllByService(Service service) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            TypedQuery<DescriptionDM> query = entityManager.createQuery("SELECT d FROM DescriptionDM d WHERE d.espace.service = :service", DescriptionDM.class);
            query.setParameter("service", service);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}

