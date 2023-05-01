package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.TypeDM;


public interface  ITypeDMDao extends IDao<TypeDM> {

    TypeDM findbyNom(String nomTypeDM);

    void createT(TypeDM t);

    void deleteTypeDM(TypeDM t);

    void updateNomTypeDM(TypeDM t, String newNomTypeDM);

    TypeDM findbyCode(String codeTypeDM);


}
