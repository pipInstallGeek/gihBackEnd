package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DispositifMedical;

import java.util.List;

public interface IDispoMedicalService {

    void ajouterDispoMed(DispositifMedical dispositifMedical);

    List<DispositifMedical> afficherDispoMedical();
}
