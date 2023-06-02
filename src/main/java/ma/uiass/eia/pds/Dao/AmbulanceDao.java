package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Service.EtatsAmbulanceService;
import ma.uiass.eia.pds.Service.IEtatsAmbulanceService;


import java.util.List;

public class AmbulanceDao implements IAmbulanceDao{

    IEtatsAmbulanceService etatsAmbulanceService=new EtatsAmbulanceService();
    private EntityManager entityManager;
    public AmbulanceDao(){this.entityManager= HibernateUtil.getEntityManger();
    }
    @Override
    public List<Ambulance> getAll() {
        return entityManager.createQuery("From Ambulance ", Ambulance.class).getResultList();
    }

    @Override
    public void add(Ambulance ambulance) {
      EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            if(ambulance.getEtatsAmbulance()==null){ambulance.setEtatsAmbulance(etatsAmbulanceService.afficherTout().get(0));}
            entityManager.persist(ambulance);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();

           /* EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.persist(ambulance);
                transaction.commit();

            }catch (Exception e){
                if (transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();*/
            }

    }

    @Override
    public Ambulance getById(int idAmbulance) {
        Ambulance ambulance = entityManager.find(Ambulance.class, idAmbulance);
        if(ambulance == null){
            System.out.println("Not found");
            return null;
        }
        return ambulance;
    }

    @Override
    public void UpdateState(Ambulance amb) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(amb);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();}

    }

}
