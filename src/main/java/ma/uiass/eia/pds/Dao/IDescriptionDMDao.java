package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DescriptionDM;

import java.util.List;

public interface IDescriptionDMDao extends IDao<DescriptionDM> {
    List<DescriptionDM> getDmByNomType(String NomTypeDM);
    DescriptionDM findbyNom(String nomDM);
    void Create(DescriptionDM d);
    int getQuantitéByDM(String nomDM);
}
