package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.HistoriqueEtats;

import java.util.List;

public class HistoriqueEtatsDao implements IHistoriqueEtatsDao{
    private EntityManager entityManager;
    public HistoriqueEtatsDao(){this.entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<HistoriqueEtats> getAll() {
        return entityManager.createQuery("From HistoriqueEtats ", HistoriqueEtats.class).getResultList();
    }

    @Override
    public void add(HistoriqueEtats historiqueEtats) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(historiqueEtats);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public HistoriqueEtats getById(int idHistorique) {
        HistoriqueEtats historiqueEtats = entityManager.find(HistoriqueEtats.class, idHistorique);
        if(historiqueEtats == null){
            System.out.println("Not found");
            return null;
        }
        return historiqueEtats;
    }
}
