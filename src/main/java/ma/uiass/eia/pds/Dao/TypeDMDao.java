package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class TypeDMDAO implements ITypeDMDao {
    private EntityManager entityManager;

    public TypeDMDAO() {
        entityManager = HibernateUtil.getEntityManger();
    }


    @Override
    public List<TypeDM> getAll() {
        return entityManager.createQuery("From TypeDM", TypeDM.class).getResultList();
    }

    @Override
    public void add(TypeDM typeDM) {
        EntityTransaction transaction =entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(typeDM);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public TypeDM getById(int id) {
        return null;
    }

    @Override
    public TypeDM findbyNom(String typeDM) {
        try {
            TypedQuery<TypeDM> query = entityManager.createQuery("From TypeDM t where t.nomTypeDM =: nomTypeDM", TypeDM.class);
            query.setParameter("nomTypeDM", typeDM);
            return query.getSingleResult();
        }catch (NonUniqueResultException e){
            return null;
        }

    }
}
