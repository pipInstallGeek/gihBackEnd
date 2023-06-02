package ma.uiass.eia.pds.Dao;


import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.EtatsAmbulance;
import ma.uiass.eia.pds.Model.Revision;

import java.util.List;

public interface IRevisionDao extends IDao<Revision>{
    List<Revision> getRevisionByAmbulance(int idAmb);
    void DeleteRevision(Revision revision);

}
