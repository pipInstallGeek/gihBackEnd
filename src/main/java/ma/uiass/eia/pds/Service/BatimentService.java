package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.BatimentDao;
import ma.uiass.eia.pds.Dao.IBatimentDao;
import ma.uiass.eia.pds.Model.Batiment;
import ma.uiass.eia.pds.Model.DescriptionDM;

import java.util.List;

public class BatimentService implements IBatimentService{
    IBatimentDao batimentDao = new BatimentDao();
    @Override
    public void ajouter(Batiment batiment) {
        batimentDao.add(batiment);
    }

    @Override
    public List<Batiment> afficherTout() {
        return batimentDao.getAll();
    }

    @Override
    public Batiment trouverId(int id) {
        return batimentDao.getById(id);
    }
}