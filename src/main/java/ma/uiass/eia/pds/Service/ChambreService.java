package ma.uiass.eia.pds.Service;
import ma.uiass.eia.pds.Dao.ChambreDao;

import ma.uiass.eia.pds.Dao.IEspaceDao;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public class ChambreService implements IEspaceService<Chambre> {
    private IEspaceDao chambreDao = new ChambreDao();

    @Override
    public void ajouter(Chambre chambre) {
        chambreDao.add(chambre);

    }

    @Override
    public List<Chambre> afficherTout() {

        return chambreDao.getAll();
    }

    @Override
    public Chambre trouverId(int id) {
        return (Chambre)chambreDao.getById(id);
    }

    @Override
    public void retirerLit(Lit l) {
        chambreDao.remove(l);
    }
}
