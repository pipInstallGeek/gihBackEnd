package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DescriptionDM;

import java.util.List;

public interface IDescriptionDMService extends IService<DescriptionDM> {
    List<DescriptionDM> trouverDMByTypeDM(String  TypeDM);
}
