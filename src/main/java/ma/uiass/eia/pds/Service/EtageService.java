package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.EtageDao;
import ma.uiass.eia.pds.Dao.IEtageDao;
import ma.uiass.eia.pds.Model.Etage;

import java.util.List;

public class EtageService implements IEtageService{
    IEtageDao etageDao = new EtageDao();
    @Override
    public void ajouter(Etage etage) {
        etageDao.add(etage);
    }

    @Override
    public List<Etage> afficherTout() {
        return etageDao.getAll();
    }

    @Override
    public Etage trouverId(int id) {
        return etageDao.getById(id);
    }
}
