package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DetailsLivraisonDao;
import ma.uiass.eia.pds.Model.DetailsLivraison;

import java.util.List;

public class DetailsLivraisonServiceImp implements IDetailsLivraisonService{
    private DetailsLivraisonDao detailsLivraisonDao=new DetailsLivraisonDao();

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
}
