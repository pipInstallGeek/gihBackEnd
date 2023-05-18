package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.StateAMB;

public interface IAmbulanceDao extends IDao<Ambulance> {
    Ambulance findbyCode(String codeAMB);
    void updateState(Ambulance ambulance, StateAMB newState);
    void updateS(Ambulance a,double kilo);
}
