package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Salle;

import java.util.List;

public class SalleDao implements IEspaceDao<Salle> {
    EntityManager entityManager;
    public SalleDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Salle> getAll() {
        return entityManager.createQuery("from Salle ", Salle.class).getResultList();
    }

    @Override
    public void add(Salle salle) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(salle);
            salle.setCodeEspace("S"+salle.getService().getCodeService()+salle.getIdEspace());
            entityManager.merge(salle);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Salle getById(int id) {
        return entityManager.find(Salle.class, id);
    }
    @Override
    public Espace findbyCode(String codeEspace) {
        TypedQuery<Salle> query = entityManager.createQuery("SELECT c FROM Salle c WHERE c.codeEspace = :codeEspace", Salle.class);
        query.setParameter("codeEspace", codeEspace);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }






}