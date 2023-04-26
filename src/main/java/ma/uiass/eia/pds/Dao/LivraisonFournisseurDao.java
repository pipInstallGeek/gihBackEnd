package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
import ma.uiass.eia.pds.Model.*;

import java.util.List;

public class LivraisonFournisseurDao implements ILivraisonFournisseurDao {
    private final EntityManager entityManager;
    private final IDetailsLivraisonDao detailsLivraisonDao = new DetailsLivraisonDao();
    private final IDispoMedicalDao dispoMedicalDao = new DispoMedicalDao();
    private final  IStockDao stockDao = new StockDao();
    private final IStocksDetailsDao stocksDetailsDao = new StocksDetailsDao();
    public LivraisonFournisseurDao(){
        entityManager =  HibernateUtil.getEntityManger();
    }

    @Override
    public List<LivraisonFournisseur> getAll() {
        return entityManager.createQuery("From LivraisonFournisseur", LivraisonFournisseur.class).getResultList();

    }

    @Override
    public void add(LivraisonFournisseur livraisonFournisseur) {
        EntityTransaction transaction = entityManager.getTransaction();

        List<DetailsLivraison> detailsLivraisons = livraisonFournisseur.getDetailsLivraisons();
        transaction.begin();
        try {


            entityManager.persist(livraisonFournisseur);
            detailsLivraisons.forEach(detailsLivraison -> {
                detailsLivraison.setLivraisonFournisseur(livraisonFournisseur);
                detailsLivraisonDao.add(detailsLivraison);
                StocksDetails stocksDetails = new StocksDetails(detailsLivraison.getDispositifMedical(),stockDao.getById(1), detailsLivraison.getQuantite());

                stocksDetailsDao.add(stocksDetails);
            });
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public LivraisonFournisseur getById(int id) {
        LivraisonFournisseur livraisonFournisseur = entityManager.find(LivraisonFournisseur.class, id);
        if(livraisonFournisseur == null){
            System.out.println("Not found");
            return null;
        }
        return livraisonFournisseur;
    }


}
