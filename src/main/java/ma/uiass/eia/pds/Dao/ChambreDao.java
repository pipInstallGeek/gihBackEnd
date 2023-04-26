package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Salle;


import java.util.List;
public class ChambreDao implements IEspaceDao<Chambre> {
    private EntityManager entityManager;
    public ChambreDao() {
        entityManager = HibernateUtil.getEntityManger();
    }

    @Override
    public void add(Chambre chambre) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(chambre);
            chambre.setCodeEspace("C"+chambre.getService().getCodeService()+chambre.getIdEspace());
            entityManager.merge(chambre);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public List<Chambre> getAll() {
        return entityManager.createQuery("from Chambre ", Chambre.class).getResultList();
    }

    @Override
    public Chambre getById(int idChambre) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Chambre response=(Chambre) entityManager.find(Chambre.class,idChambre);
            transaction.commit();
            return response;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Espace findbyCode(String codeEspace) {
        TypedQuery<Chambre> query = entityManager.createQuery("SELECT c FROM Chambre c WHERE c.codeEspace = :codeEspace", Chambre.class);
        query.setParameter("codeEspace", codeEspace);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }



}
