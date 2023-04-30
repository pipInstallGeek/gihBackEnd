package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
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
    public TypeDM findbyCode(String codeTypeDM) {
        TypedQuery<TypeDM> query = entityManager.createQuery("FROM TypeDM t WHERE t.codeTypeDM = :codeTypeDM", TypeDM.class);
        query.setParameter("codeTypeDM", codeTypeDM);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
    /*@Override
    public TypeDM findbyNom(String NomTypeDM) {
        TypedQuery<TypeDM> query = entityManager.createQuery(" FROM TypeDM t WHERE t.NomTypeDM = :NomTypeDM", TypeDM.class);
        query.setParameter("NomTypeDM", NomTypeDM);
        return query.getResultList();
    }*/




}
