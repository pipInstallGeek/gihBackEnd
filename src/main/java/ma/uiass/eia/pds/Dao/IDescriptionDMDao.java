package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DescriptionDM;

import java.util.List;

public interface IDescriptionDMDao extends IDao<DescriptionDM> {
    List<DescriptionDM> getDmByNomType(String NomTypeDM);
}
