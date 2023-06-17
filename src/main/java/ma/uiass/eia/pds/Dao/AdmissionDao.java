package ma.uiass.eia.pds.Dao;

        import jakarta.persistence.*;
        import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
        import ma.uiass.eia.pds.Model.*;

        import java.util.List;

public class AdmissionDao implements IAdmissionDao {
    private EntityManager entityManager ;
    public AdmissionDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Admission> getAll() {
        return entityManager.createQuery(" from Admission ").getResultList();
    }
    @Override
    public Admission getById(int id) {
        return entityManager.find(Admission.class, id);
    }


   /* public void add(Admission admission) {
        EntityTransaction transaction = entityManager.getTransaction();
        List<Lit> availableBeds = entityManager.createQuery("select l from Lit l where l.etatLit = :etat and l.occupe = false", Lit.class)
                .setParameter("etat", EtatLit.BONNNEETAT)
                .getResultList();
        for (Lit lit : availableBeds) {
            if (lit.isAvailableAndGoodCondition()) {
                admission.setLit(entityManager.find(Lit.class, lit.getIdLit()));
                lit.setOccupe(true);
                break;
            }
        }
        try {
            transaction.begin();
            entityManager.persist(admission);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }*/
    public int getMaxAdmissionIdFromDatabase() {
        Object maxId = entityManager.createQuery("select max(a.idAdmission) from Admission a").getSingleResult();
        if (maxId != null) {
            return (int) maxId;
        } else {
            return 0;
        }
    }public void add(Admission admission) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(admission);
            admission.getLit().setOccupe(true);
           entityManager.merge(admission);
            admission.setNumAdmission("ADM_"+ admission.getIdAdmission());
            entityManager.merge(admission);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
     //  admission.setDateFin(null); // initialiser la date de fin à null
       try {
           transaction.begin();
           entityManager.persist(admission);
           transaction.commit();
       }catch (Exception e){
           if (transaction != null){
               transaction.rollback();
           }
           e.printStackTrace();
       }
   }

    @Override
    public void update(Admission admission) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Admission admissionToUpdate = findbyCode(admission.getNumAdmission());
            Lit lit = admissionToUpdate.getLit();
            lit.setOccupe(false);
            entityManager.merge(lit);
            admissionToUpdate.setDateFin(admission.getDateFin());
            entityManager.merge(admissionToUpdate);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public Admission findbyCode(String NumAdmission) {
        TypedQuery<Admission> query = entityManager.createQuery("SELECT a FROM Admission a WHERE a.numAdmission = :NumAdmission", Admission.class);
        query.setParameter("NumAdmission", NumAdmission);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }

    }
    public List<Admission> getAllByService(Service service) {
        TypedQuery<Admission> query = entityManager.createQuery("SELECT a FROM Admission a WHERE a.lit.espace.service = :service", Admission.class);
        query.setParameter("service", service);
        return query.getResultList();
    }

}



