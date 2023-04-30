package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class TypeDMDao implements ITypeDMDao {
    private EntityManager entityManager ;
   public TypeDMDao(){entityManager = HibernateUtil.getEntityManger();}
    @Override
    public List<TypeDM> getAll() {return entityManager.createQuery(" from TypeDM ").getResultList();}
    @Override
    public void add(TypeDM typeDM) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(typeDM);
            typeDM.setCodeTypeDM(typeDM.getCodeTypeDM()+typeDM.getIdTypeDM());
            //entityManager.merge(typeDM);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public TypeDM getById(int id) {
        return entityManager.find(TypeDM.class, id);
    }
    @Override
    public TypeDM findbyNom(String nomTypeDM) {
        TypedQuery<TypeDM> query = entityManager.createQuery("FROM TypeDM t WHERE t.nomTypeDM = :nomTypeDM", TypeDM.class);
        query.setParameter("nomTypeDM", nomTypeDM);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
    /*@Override
    public List<TypeDM> getTypeDmByNomDm(String nomDM) {
        TypedQuery<TypeDM> query = entityManager.createQuery(
                "SELECT t FROM TypeDM t WHERE t.dmDescription.nomDM = :nomDM", TypeDM.class);
        query.setParameter("nomDM", nomDM);
        return query.getResultList();
    }*/
    @Override
    public void createT(TypeDM t){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(t);
            t.setCodeTypeDM(t.getCodeTypeDM()+t.getIdTypeDM());
            //entityManager.merge(typeDM);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
    @Override
    public void deleteTypeDM(TypeDM t) {
        EntityTransaction et = null;
        try {
            et= entityManager.getTransaction();
            if(!et.isActive()){
                et.begin();
            }
            entityManager.remove(t);
            et.commit();
        }catch (Exception e){
            if(et!=null){
                et.rollback();
            }
            e.printStackTrace();
        }
    }




}
