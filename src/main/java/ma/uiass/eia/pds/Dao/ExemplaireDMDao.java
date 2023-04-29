package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.ExemplaireDM;

import java.util.List;

public class ExemplaireDMDao implements IExemplaireDMDao {
    private EntityManager entityManager;

    public ExemplaireDMDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<ExemplaireDM> getAll() {
        return entityManager.createQuery(" from ExemplaireDM ").getResultList();
    }

    @Override
    public void add(ExemplaireDM exemplaireDM) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(exemplaireDM);
            exemplaireDM.setCodeDME(exemplaireDM.getDmDescription().getCodeDM() + exemplaireDM.getIdDME());
            //entityManager.merge(exemplaireDM);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public ExemplaireDM getById(int id) {
        return entityManager.find(ExemplaireDM.class, id);
    }

    @Override
    public List<ExemplaireDM> getExemplaireByDMetTypeDm(String NomDM) {
        TypedQuery<ExemplaireDM> query = entityManager.createQuery(
                "SELECT e FROM ExemplaireDM e WHERE e.dmDescription.nomDM = :NomDM", ExemplaireDM.class);
        query.setParameter("NomDM", NomDM);
        return query.getResultList();
    }
}
