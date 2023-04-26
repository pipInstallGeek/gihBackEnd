package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Admission;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.TypeDM;

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
            descriptionDM.setCodeDM(descriptionDM.getTypeDM().getCodeTypeDM() + descriptionDM.getNomDM());
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
            d.setCodeDM(d.getTypeDM().getCodeTypeDM() + d.getNomDM());
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
    public List<DescriptionDM> getDmByNomType(String nomTypeDM) {
        TypedQuery<DescriptionDM> query = entityManager.createQuery(
                "SELECT d FROM DescriptionDM d WHERE d.typeDM.nomTypeDM = :nomTypeDM", DescriptionDM.class);
        query.setParameter("nomTypeDM", nomTypeDM);
        return query.getResultList();
    }

    @Override
    public DescriptionDM findbyNom(String nomDM) {
        Query query = entityManager.createQuery("SELECT t FROM  DescriptionDM t WHERE t.nomDM = :nomDM ", DescriptionDM.class);
        query.setParameter("nomDM", nomDM);
        try {
            return (DescriptionDM) query.getSingleResult();
        } catch (NonUniqueResultException e) {
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
}

