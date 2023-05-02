package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class TypeDmDAO implements ITypeDmDAO{
    private EntityManager entityManager;

    public TypeDmDAO() {
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
        TypeDM typeDM = entityManager.find(TypeDM.class, id);
        if(typeDM == null){
            System.out.println("Not found");
            return null;
        }
        return typeDM;
    }

    @Override
    public void deleteTypeDM(TypeDM typeDM) {
        EntityTransaction transaction =entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(typeDM);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }
}
