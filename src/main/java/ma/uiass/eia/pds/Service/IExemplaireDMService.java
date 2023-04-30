package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.ExemplaireDM;

import java.util.List;

public interface IExemplaireDMService extends IService<ExemplaireDM> {
    List<ExemplaireDM> trouvezExemplaireByDMetTypeDm(String nomDM) ;}
