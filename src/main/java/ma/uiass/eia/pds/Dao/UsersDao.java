package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Users;
import java.util.List;

public class UsersDao implements IUsersDao {
    private EntityManager entityManager ;
    public UsersDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Users> getAll() {return entityManager.createQuery("select r from Users r ").getResultList();}

    @Override
    public void add(Users user) {
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
    public Users getById(int id) {
        return null;
    }

    @Override
    public void update(Users users) {

    }


}
