package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public interface  ITypeDMDao extends IDao<TypeDM> {
    //List<TypeDM> getTypeDmByNomDm(String codeTypeDM);
    TypeDM findbyNom(String nomTypeDM);
    void createT(TypeDM t);
    void deleteTypeDM(TypeDM t);
    void updateNomTypeDM(TypeDM t, String newNomTypeDM);
}
