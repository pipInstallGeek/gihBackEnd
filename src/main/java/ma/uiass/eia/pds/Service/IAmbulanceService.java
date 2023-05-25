package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.EtatsAmbulance;
import ma.uiass.eia.pds.Model.Revision;

public interface IAmbulanceService extends IService<Ambulance>{
    void Changertat(Ambulance amb);
}
