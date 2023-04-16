package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.TypeDM;

public interface  ITypeDMDao extends IDao<TypeDM> {
    TypeDM findbyCode(String codeTypeDM);
}
