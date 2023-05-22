package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.DispoMedicItem;
import ma.uiass.eia.pds.Model.Revision;

import java.util.List;

public class RevisionDao implements IRevisionDao{
    private EntityManager entityManager;
    public RevisionDao(){ this.entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Revision> getAll() {
        return entityManager.createQuery("from Revision",Revision.class).getResultList();
    }

    @Override
    public void add(Revision revision) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(revision);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Revision getById(int idRevision) {
        Revision revision = entityManager.find(Revision.class, idRevision);
        if(revision == null){
            System.out.println("Not found");
            return null;
        }
        return revision;

    }

        public List<Revision> getRevisionByAmbulance(int idAmb) {
            return entityManager.createQuery("SELECT r FROM Revision r WHERE r.ambulance.id = :idAmb", Revision.class)
                    .setParameter("idAmb", idAmb)
                    .getResultList();
        }

    @Override
    public void DeleteRevision(Revision revision) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                entityManager.remove(revision);
                transaction.commit();
            }catch (Exception e){
                if (transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }



}
