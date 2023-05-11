package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.HistoriqueEtatsDao;
import ma.uiass.eia.pds.Dao.IHistoriqueEtatsDao;
import ma.uiass.eia.pds.Model.HistoriqueEtats;

import java.util.List;

public class HistoriqueEtatService implements IHistoriqueEtatService{
    private IHistoriqueEtatsDao historiqueEtatsDao = new HistoriqueEtatsDao();
    @Override
    public void ajouter(HistoriqueEtats historiqueEtats) {
        historiqueEtatsDao.add(historiqueEtats);

    }

    @Override
    public List<HistoriqueEtats> afficherTout() {
        return historiqueEtatsDao.getAll();
    }

    @Override
    public HistoriqueEtats trouverId(int idHistorique) {
        return historiqueEtatsDao.getById(idHistorique);
    }
}
