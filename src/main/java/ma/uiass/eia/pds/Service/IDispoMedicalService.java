package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DispositifMedical;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public interface IDispoMedicalService {

    void ajouterDispoMed(DispositifMedical dispositifMedical);

    List<DispositifMedical> afficherDispoMedical();

    List<DispositifMedical> getbytype(int idTypeDm);

}
