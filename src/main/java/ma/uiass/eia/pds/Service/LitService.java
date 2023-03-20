package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ILitDao;
import ma.uiass.eia.pds.Dao.LitDao;
import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public class LitService implements ILitService{
    private ILitDao litDao = new LitDao();

    @Override
    public void ajouter(Lit lit) {
        litDao.add(lit);
    }

    @Override
    public List<Lit> afficherTout() {
        return litDao.getAll();
    }

    @Override
    public Lit trouverId(int id) {

        return litDao.getById(id);
    }
}
