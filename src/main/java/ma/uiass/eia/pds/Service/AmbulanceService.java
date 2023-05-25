package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.AmbulanceDao;
import ma.uiass.eia.pds.Dao.IAmbulanceDao;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.EtatsAmbulance;

import java.util.List;

public class AmbulanceService implements IAmbulanceService{
    private IAmbulanceDao ambulanceDao = new AmbulanceDao();
    @Override
    public void ajouter(Ambulance ambulance) {
        ambulanceDao.add(ambulance);
    }

    @Override
    public List<Ambulance> afficherTout() {
        return ambulanceDao.getAll();
    }

    @Override
    public Ambulance trouverId(int idAmbulance) {
        return ambulanceDao.getById(idAmbulance);
    }

    @Override
    public void Changertat(Ambulance amb) {
        ambulanceDao.UpdateState(amb);
    }
}
