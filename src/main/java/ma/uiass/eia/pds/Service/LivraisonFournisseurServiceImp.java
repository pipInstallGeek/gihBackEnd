package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.LivraisonFournisseurDao;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;

import java.util.List;

public class LivraisonFournisseurServiceImp implements ILivraisonFournisseurService{
    private LivraisonFournisseurDao livraisonFournisseurDao=new LivraisonFournisseurDao();

    @Override
    public void ajouter(LivraisonFournisseur livraisonFournisseur) {
        livraisonFournisseurDao.add(livraisonFournisseur);
    }

    @Override
    public List<LivraisonFournisseur> afficherTout() {
        return livraisonFournisseurDao.getAll();
    }

    @Override
    public LivraisonFournisseur trouverId(int id) {
        return livraisonFournisseurDao.getById(id);
    }
}
