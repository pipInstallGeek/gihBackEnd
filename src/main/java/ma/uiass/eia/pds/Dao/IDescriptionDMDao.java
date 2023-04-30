package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DispositifMedical;

import java.util.List;

public interface IDescriptionDMDao extends IDao<DispositifMedical> {
    List<DispositifMedical> getDmByNomType(String NomTypeDM);
    DispositifMedical findbyNom(String nomDM);
    void Create(DispositifMedical d);
    int getQuantitéByDM(String nomDM);
    void  deleteDM(DispositifMedical d);
}
