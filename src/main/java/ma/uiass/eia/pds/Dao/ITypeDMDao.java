package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.TypeDM;

public interface  ITypeDMDao extends IDao<TypeDM> {
    //List<TypeDM> getTypeDmByNomDm(String codeTypeDM);
    TypeDM findbyCode(String codeTypeDM);

    //TypeDM findbyNom(String NomTypeDM);
}
