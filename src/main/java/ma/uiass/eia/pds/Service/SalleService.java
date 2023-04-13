package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IEspaceDao;
import ma.uiass.eia.pds.Dao.SalleDao;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Salle;

import java.util.List;

public class SalleService implements IEspaceService<Salle> {
    IEspaceDao<Salle> salleDao = new SalleDao();

    @Override
    public void ajouter(Salle salle) {
        salleDao.add(salle);
    }

    @Override
    public List<Salle> afficherTout() {
        return salleDao.getAll();
    }

    @Override
    public Salle trouverId(int id) {
        return salleDao.getById(id);
    }


}
