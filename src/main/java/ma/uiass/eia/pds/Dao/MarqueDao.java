package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.Marque;

import java.util.List;

public class MarqueDao implements IMarqueDao{
    private EntityManager entityManager;
    public MarqueDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
   /* // Création d'un EntityManagerFactory
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("nom_de_votre_unité_de_persistence");

    // Création d'un EntityManager
    EntityManager em = emf.createEntityManager();

    // Création d'une requête pour récupérer toutes les marques
    TypedQuery<Marque> query = em.createQuery("SELECT m FROM Marque m", Marque.class);

    // Exécution de la requête pour récupérer la liste des marques
    List<Marque> listeMarques = query.getResultList();

    // Création du choix box et association de la liste des marques
    ChoiceBox<Marque> choixBoxMarques = new ChoiceBox<>();
choixBoxMarques.setItems(FXCollections.observableArrayList(listeMarques));*/


    @Override
    public List<Marque> getAll() {
        return entityManager.createQuery("SELECT m FROM Marque m", Marque.class).getResultList();
    }

    @Override
    public void add(Marque marque) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(marque);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Marque getById(int id) {
        return null;
    }

    @Override
    public Marque getByCode(String codeMarque) {
       TypedQuery<Marque> query = entityManager.createQuery("FROM Marque m WHERE m.codeMarque= :codeMarque ", Marque.class);
       query.setParameter("codeMarque",codeMarque);
       try{
           return query.getSingleResult();
       }catch(NonUniqueResultException e){
           return null;
       }
    }
}
