package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ILivraisonDao;
import ma.uiass.eia.pds.Dao.LivraisonFournisseurDao;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;

import java.util.List;

public class LivraisonFourniseurService implements ILivraisonService{

    ILivraisonDao livraisonDao = new LivraisonFournisseurDao();
    @Override
    public void ajouter(LivraisonFournisseur livraisonFournisseur) {
        livraisonDao.add(livraisonFournisseur);
    }

    @Override
    public List<LivraisonFournisseur> afficherTout() {
        return livraisonDao.getAll();
    }

    @Override
    public LivraisonFournisseur trouverId(int id) {
        return livraisonDao.getById(id);

    }
}
