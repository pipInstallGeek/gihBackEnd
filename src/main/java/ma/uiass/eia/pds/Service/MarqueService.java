package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IMarqueDao;
import ma.uiass.eia.pds.Dao.MarqueDao;
import ma.uiass.eia.pds.Model.Marque;

import java.util.List;

public class MarqueService implements IMarqueService{
    IMarqueDao marqueDao = new MarqueDao();
    @Override
    public void ajouter(Marque marque) {
        marqueDao.add(marque);
    }

    @Override
    public List<Marque> afficherTout() {
        return marqueDao.getAll();
    }

    @Override
    public Marque trouverId(int id) {
        return null;
    }

    @Override
    public Marque trouverCode(String codeMarque) {
        return marqueDao.getByCode(codeMarque);
    }
}
