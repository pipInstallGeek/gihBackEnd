package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DetailsLivraisonDao;
import ma.uiass.eia.pds.Dao.IDetailsLivraisonDao;
import ma.uiass.eia.pds.Dao.ILivraisonFournisseurDao;
import ma.uiass.eia.pds.Dao.LivraisonFournisseurDao;
import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;

import java.util.List;

public class DetailsLivraisonService implements IDetailsLivraisonService{
    private IDetailsLivraisonDao detailsLivraisonDao = new DetailsLivraisonDao();
    private ILivraisonFournisseurDao livraisonFournisseurDao =  new LivraisonFournisseurDao();
    @Override
    public void ajouter(DetailsLivraison detailsLivraison) {
        detailsLivraisonDao.add(detailsLivraison);
    }

    @Override
    public List<DetailsLivraison> afficherTout() {
        return detailsLivraisonDao.getAll();
    }

    @Override
    public DetailsLivraison trouverId(int id) {
        return detailsLivraisonDao.getById(id);
    }

    @Override
    public List<DetailsLivraison> getbyLivraison(int idLivraisonFournisseur) {
        LivraisonFournisseur livraisonFournisseur = livraisonFournisseurDao.getById(idLivraisonFournisseur);

        return detailsLivraisonDao.getbyLivraison(livraisonFournisseur);
    }
}
