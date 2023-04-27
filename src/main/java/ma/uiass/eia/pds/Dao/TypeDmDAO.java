package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Commande;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.Date;
import java.util.List;

public class TypeDMDao implements ITypeDMDao {
    private EntityManager entityManager;
    public TypeDMDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<TypeDM> getAll() {
        return entityManager.createQuery("from TypeDM r", TypeDM.class).getResultList();
    }
    @Override
    public void add(TypeDM typeDM) {
        EntityTransaction et = entityManager.getTransaction();
        try {
            et.begin();
            entityManager.persist(typeDM);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public TypeDM getById(int idCommande) {

        return entityManager.find(TypeDM.class, idCommande);
    }

}
