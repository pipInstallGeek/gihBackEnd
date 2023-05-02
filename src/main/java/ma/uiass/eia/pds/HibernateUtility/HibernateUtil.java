package ma.uiass.eia.pds.HibernateUtility;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class   HibernateUtil {
    private static EntityManager entityManager = null ;
    public static EntityManager getEntityManger() {
        if (entityManager == null) {
            try {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_SC");
                entityManager = factory.createEntityManager();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return entityManager;
    }
}