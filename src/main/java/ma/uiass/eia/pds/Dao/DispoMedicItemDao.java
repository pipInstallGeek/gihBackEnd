package ma.uiass.eia.pds.Dao;

import com.mysql.cj.Session;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DispoMedicItem;
import ma.uiass.eia.pds.Model.DispoMedical;
import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public class DispoMedicItemDao implements IDispoMedicItemDao{

    private final EntityManager entityManager;

    public DispoMedicItemDao(){
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public List<DispoMedicItem> getAll() {
        return entityManager.createQuery("From DispoMedicItem", DispoMedicItem.class).getResultList();
    }

    @Override
    public void add(DispoMedicItem dispoMedicItem) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(dispoMedicItem);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public DispoMedicItem getById(int id) {
        DispoMedicItem dispoMedicItem = entityManager.find(DispoMedicItem.class, id);
        if(dispoMedicItem == null){
            System.out.println("Not found");
            return null;
        }
        return dispoMedicItem;

    }


    @Override
    public void deleteDmItem(DispoMedicItem dispoMedicItem) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(dispoMedicItem);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateEspace(int idItem, String espaceItem) {
        EntityTransaction transaction = entityManager.getTransaction();
        DispoMedicItem item=getById(idItem);
        try {
            transaction.begin();
            // Update the espaceItem attribute of the DispoMedicItem
            item.setEspaceItem(espaceItem);

            transaction.commit();
            // Save the updated item

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
