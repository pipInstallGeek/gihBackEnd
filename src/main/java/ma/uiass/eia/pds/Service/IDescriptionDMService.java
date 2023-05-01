package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DispositifMedical;

import java.util.List;

public interface IDescriptionDMService extends IService<DispositifMedical> {
    List<DispositifMedical> trouverDMByTypeDM(String  TypeDM);

    DispositifMedical trouverNom(String nom);
}
