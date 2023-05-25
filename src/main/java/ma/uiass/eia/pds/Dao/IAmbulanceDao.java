package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.EtatsAmbulance;
import ma.uiass.eia.pds.Model.Revision;

public interface IAmbulanceDao extends IDao<Ambulance> {

    void UpdateState(Ambulance amb);
}
