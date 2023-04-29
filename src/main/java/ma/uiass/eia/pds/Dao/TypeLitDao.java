package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.TypeLit;

import java.util.List;

public class TypeLitDao implements ITypeLitDao{
    private EntityManager entityManager ;
    public TypeLitDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<TypeLit> getAll() {
        return entityManager.createQuery("from TypeLit ", TypeLit.class).getResultList();
    }

    @Override
    public void add(TypeLit typeLit) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(typeLit);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public TypeLit getById(int id) {
        return entityManager.find(TypeLit.class, id);
    }
}