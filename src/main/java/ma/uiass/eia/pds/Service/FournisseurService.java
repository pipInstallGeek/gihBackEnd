package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.FournisseurDao;
import ma.uiass.eia.pds.Dao.IFournisseurDao;
import ma.uiass.eia.pds.Model.Fournisseur;

import java.util.List;

public class FournisseurService implements IFournisseurService {
    IFournisseurDao fournisseurDao = new FournisseurDao();
    @Override
    public void ajouter(Fournisseur fournisseur) {
        fournisseurDao.add(fournisseur);
    }

    @Override
    public List<Fournisseur> afficherTout() {
        return fournisseurDao.getAll();
    }

    @Override
    public Fournisseur trouverId(int id) {
        return fournisseurDao.getById(id);
    }
}
