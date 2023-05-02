package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IReappLitDao;
import ma.uiass.eia.pds.Dao.ReappLitDao;
import ma.uiass.eia.pds.Model.ReapprovisionnementLit;

import java.util.List;

public class ReappLitService implements IReappLitService{
    IReappLitDao reappLitDao = new ReappLitDao();
    @Override
    public void ajouter(ReapprovisionnementLit reapprovisionnementLit) {
        reappLitDao.add(reapprovisionnementLit);
    }

    @Override
    public List<ReapprovisionnementLit> afficherTout() {
        return reappLitDao.getAll();
    }

    @Override
    public ReapprovisionnementLit trouverId(int id) {
        return reappLitDao.getById(id);
    }
}
