package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DispositifMedical;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.ArrayList;
import java.util.List;

public class DispoMedicalDao implements IDispoMedicalDao {


    private EntityManager entityManager;

    public DispoMedicalDao() {
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<DispositifMedical> getAll() {
        return entityManager.createQuery("From DispositifMedical ", DispositifMedical.class).getResultList();
    }

    @Override
    public void add(DispositifMedical dispositifMedical) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(dispositifMedical);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public DispositifMedical getById(int id) {
        return null;
    }


    @Override
    public List<DispositifMedical> getbytype(TypeDM typeDM) {
        List<DispositifMedical> dispositifMedicals = getAll();
        List<DispositifMedical> filter = new ArrayList<>();
        for (DispositifMedical dispositifMedical : dispositifMedicals){
            if (dispositifMedical.getTypeDM().getIdTypeDM()== typeDM.getIdTypeDM()){
                filter.add(dispositifMedical);
            }
        }
        return filter;
    }
}
