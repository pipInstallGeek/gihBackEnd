package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DescriptionDM;

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
            descriptionDM.setCodeDM(descriptionDM.getTypeDM().getCodeTypeDM()+descriptionDM.getNomDM());
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
    public DescriptionDM getById(int id) {
        return entityManager.find(DescriptionDM.class, id);
    }

    @Override
    public List<DescriptionDM> getDmByNomType(String NomTypeDM) {
        TypedQuery<DescriptionDM> query = entityManager.createQuery(
                "SELECT d FROM DescriptionDM d WHERE d.typeDM.NomTypeDM = :NomTypeDM" , DescriptionDM.class);
        query.setParameter("NomTypeDM" , NomTypeDM);
        return query.getResultList();
    }
    @Override
    public DescriptionDM searchByNom(String nom){
        TypedQuery<DescriptionDM> query = entityManager.createQuery("From DescriptionDM WHERE nomDM=:nom",DescriptionDM.class);
        query.setParameter("nom",nom);
        try{
            return query.getSingleResult();
        }catch (NonUniqueResultException e){
            return  null;
        }
    }
}
