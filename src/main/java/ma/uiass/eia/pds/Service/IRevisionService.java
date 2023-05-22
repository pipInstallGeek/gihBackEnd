package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.Revision;

import java.util.List;

public interface IRevisionService extends IService<Revision>{
    List<Revision> afficherRevisionParAmbulance(int ambulance);
    void SupprimerRevision(int idRev);
}
