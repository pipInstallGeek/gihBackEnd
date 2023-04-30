package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.TypeDM;

public interface ITypeDMService extends IService<TypeDM> {

    //List<TypeDM> trouverTypeDMByDM(String  idDM);
    void addTypeDM(String NomTypeDM);
}
