package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.EtatsAmbulance;

import java.util.List;

public interface IAmbulanceService extends IService<Ambulance>{
    public List<Ambulance> afficherAmbulanceEtat(String ambulance);
}
