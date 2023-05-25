package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.EtatsAmbulanceDao;
import ma.uiass.eia.pds.Dao.IEtatsAmbulanceDao;
import ma.uiass.eia.pds.Model.EtatsAmbulance;

import java.util.List;

public class EtatsAmbulanceService implements IEtatsAmbulanceService{

    private IEtatsAmbulanceDao etatsAmbulanceDao = new EtatsAmbulanceDao();
    @Override
    public void ajouter(EtatsAmbulance etatsAmbulance) {
        etatsAmbulanceDao.add(etatsAmbulance);
    }

    @Override
    public List<EtatsAmbulance> afficherTout() {
        return etatsAmbulanceDao.getAll();
    }

    @Override
    public EtatsAmbulance trouverId(int idEtat) {
        return etatsAmbulanceDao.getById(idEtat);
    }
}
