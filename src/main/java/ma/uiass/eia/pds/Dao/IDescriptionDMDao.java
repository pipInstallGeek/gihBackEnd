package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DispositifMedical;

import java.util.List;

public interface IDescriptionDMDao extends IDao<DispositifMedical> {
    List<DispositifMedical> getDmByNomType(String NomTypeDM);

    DispositifMedical searchByNom(String nom);
}
