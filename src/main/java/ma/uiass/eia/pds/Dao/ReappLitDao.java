package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.ReapprovisionnementLit;

import java.util.List;

public class ReappLitDao implements IReappLitDao {
    private EntityManager entityManager;
    public ReappLitDao(){
        this.entityManager =  HibernateUtil.getEntityManger();
    }
    @Override
    public List<ReapprovisionnementLit> getAll() {
        return entityManager.createQuery("From ReapprovisionnementLit ",ReapprovisionnementLit.class).getResultList();
    }

    @Override
    public void add(ReapprovisionnementLit reapprovisionnementLit) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(reapprovisionnementLit);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public ReapprovisionnementLit getById(int idReapp) {
        ReapprovisionnementLit reapprovisionnementLit = entityManager.find(ReapprovisionnementLit.class, idReapp);
        if(reapprovisionnementLit == null){
            System.out.println("Not found");
            return null;
        }
        return reapprovisionnementLit;
    }
}
