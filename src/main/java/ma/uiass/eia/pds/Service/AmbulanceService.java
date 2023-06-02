package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.AmbulanceDao;
import ma.uiass.eia.pds.Dao.IAmbulanceDao;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.EtatsAmbulance;

import java.util.ArrayList;
import java.util.List;

public class AmbulanceService implements IAmbulanceService{
    IEtatsAmbulanceService etatsAmbulanceService=new EtatsAmbulanceService();
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

    public List<Ambulance> afficherAmbulanceEtat(String etatambulance){
        List<Ambulance> ambulanceList=new ArrayList<>();
        for(Ambulance ambulance1:ambulanceDao.getAll()){
            if(ambulance1.getEtatsAmbulance().toString().equals(etatambulance)){
                ambulanceList.add(ambulance1);
            }
        }
        return ambulanceList;
    }

    @Override
    public void Changertat(Ambulance amb) {
        ambulanceDao.UpdateState(amb);
    }
}
