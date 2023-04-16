package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Admission;
import ma.uiass.eia.pds.Model.DescriptionDM;

import java.util.List;

public class DescriptionDMDao implements IDescriptionDMDao{
    private EntityManager entityManager ;
    public DescriptionDMDao(){entityManager = HibernateUtil.getEntityManger();}

    @Override
    public List<DescriptionDM> getAll() {return entityManager.createQuery(" from DescriptionDM ").getResultList();}

    @Override
    public void add(DescriptionDM descriptionDM) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(descriptionDM);
            descriptionDM.setCodeDM(descriptionDM.getNomDM()+descriptionDM.getIdDM());
            entityManager.merge(descriptionDM);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
    @Override
    public DescriptionDM getById(int id) {
        return entityManager.find(DescriptionDM.class, id);
    }
}
