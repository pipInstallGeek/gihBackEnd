package ma.uiass.eia.pds.Dao;

import jakarta.persistence.*;
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
            typeDM.setCodeTypeDM(typeDM.getNomTypeDM()+typeDM.getIdTypeDM());
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
        TypedQuery<TypeDM> query = entityManager.createQuery("SELECT t FROM TypeDM t WHERE t.nomTypeDM = :nomTypeDM", TypeDM.class);
        query.setParameter("nomTypeDM", nomTypeDM);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // or throw a custom exception or handle the case accordingly
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
            t.setCodeTypeDM(t.getNomTypeDM()+t.getIdTypeDM());
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
    public void updateNomTypeDM(TypeDM t, String newNomTypeDM) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            TypeDM typeDM = entityManager.find(TypeDM.class, t.getIdTypeDM());
            if (typeDM != null) {
                typeDM.setNomTypeDM(newNomTypeDM);
                entityManager.merge(t);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }




}
