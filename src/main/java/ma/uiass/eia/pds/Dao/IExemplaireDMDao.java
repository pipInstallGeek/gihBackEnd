package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.ExemplaireDM;

import java.util.List;

public interface IExemplaireDMDao extends IDao<ExemplaireDM> {
    List<ExemplaireDM> getExemplaireByDMetTypeDm(String nomDM);
}
