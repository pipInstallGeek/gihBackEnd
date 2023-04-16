package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DispoMedical;

import java.util.List;

public interface IDispoMedicalService {

    void ajouterDispoMed(DispoMedical dispoMedical);

    List<DispoMedical> afficherDispoMedical();

    DispoMedical findDMbyID(int id);


}
