package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.User;

import java.util.List;

public class UserDao implements IDao<User>{
    private  EntityManager entityManager;

    public UserDao() {
        entityManager = HibernateUtil.getEntityManger();
    }


    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void add(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);

            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public User getById(int id) {
        return null;
    }
}
