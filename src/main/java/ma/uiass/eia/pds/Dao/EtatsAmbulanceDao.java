package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.EtatsAmbulance;

import java.util.List;

public class EtatsAmbulanceDao implements IEtatsAmbulanceDao{
    private EntityManager entityManager;
    public  EtatsAmbulanceDao(){this.entityManager= HibernateUtil.getEntityManger();
    }
    @Override
    public List<EtatsAmbulance> getAll() {
        return entityManager.createQuery("From EtatsAmbulance", EtatsAmbulance.class).getResultList();
    }

    @Override
    public void add(EtatsAmbulance etatsAmbulance) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(etatsAmbulance);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public EtatsAmbulance getById(int idEtat) {
        EtatsAmbulance etatsAmbulance = entityManager.find(EtatsAmbulance.class, idEtat);
        if(etatsAmbulance == null){
            System.out.println("Not found");
            return null;
        }
        return etatsAmbulance;
    }
}
