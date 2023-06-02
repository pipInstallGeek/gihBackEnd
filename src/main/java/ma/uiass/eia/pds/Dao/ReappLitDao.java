package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.ReapprovisionnementLit;

import java.util.List;

public class ReappLitDao implements IReappLitDao {
    private EntityManager entityManager;

    private ILitDao litDao = new LitDao();
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
        Lit lit = reapprovisionnementLit.getLit();
        litDao.add(lit);
        for (int i=0; i< reapprovisionnementLit.getQuantite() - 1; i++){
            Lit lit1 = new Lit(lit.getEtatLit(), lit.getOccupe(), lit.getEspace(), lit.getTypeLit(), lit.getMarque());
            litDao.add(lit1);
        }
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
