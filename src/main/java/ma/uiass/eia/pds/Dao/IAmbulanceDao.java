package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Ambulance;

public interface IAmbulanceDao extends IDao<Ambulance>{

    void delete(Ambulance ambulance);

    void update(Ambulance ambulance);
}
