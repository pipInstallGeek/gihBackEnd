package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
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
            dispositifMedical.setCodeDM(dispositifMedical.getTypeDM().getCodeTypeDM()+ dispositifMedical.getNomDM());
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
    public DispositifMedical getById(int id) {
        return entityManager.find(DispositifMedical.class, id);
    }

    @Override
    public List<DispositifMedical> getDmByNomType(String NomTypeDM) {
        TypedQuery<DispositifMedical> query = entityManager.createQuery(
                "SELECT d FROM DispositifMedical d WHERE d.typeDM.NomTypeDM = :NomTypeDM" , DispositifMedical.class);
        query.setParameter("NomTypeDM" , NomTypeDM);
        return query.getResultList();
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
