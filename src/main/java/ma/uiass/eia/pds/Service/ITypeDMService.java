package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public interface ITypeDMService extends IService<TypeDM> {

    //List<TypeDM> trouverTypeDMByDM(String  idDM);
    void addTypeDM(String NomTypeDM);
}
