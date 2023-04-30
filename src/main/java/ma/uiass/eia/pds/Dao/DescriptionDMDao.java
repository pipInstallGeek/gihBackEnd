package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DispositifMedical;

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
    public void add(DispositifMedical dispositifMedical) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            dispositifMedical.setCodeDM(dispositifMedical.getNomDM()+ dispositifMedical.getEspace());
            //descriptionDM.setNomDM(descriptionDM.getNomDM()+descriptionDM.getEspace());

            entityManager.persist(dispositifMedical);
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
    public DispositifMedical getById(int id) {
        return entityManager.find(DispositifMedical.class, id);
    }

    @Override
    public List<DispositifMedical> getDmByNomType(String nomTypeDM) {
        TypedQuery<DispositifMedical> query = entityManager.createQuery(
                "SELECT d FROM DispositifMedical d WHERE d.typeDM.nomTypeDM = :nomTypeDM", DispositifMedical.class);
        query.setParameter("nomTypeDM", nomTypeDM);
        return query.getResultList();
    }

    @Override
    public DispositifMedical findbyNom(String nomDM) {
        TypedQuery<DispositifMedical> query = entityManager.createQuery("SELECT t FROM DispositifMedical t WHERE t.nomDM = :nomDM", DispositifMedical.class);
        query.setParameter("nomDM", nomDM);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Or throw a custom exception
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
    @Override
    public void deleteDM(DispositifMedical d) {
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
}

