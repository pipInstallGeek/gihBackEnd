package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.TypeDM;



public interface ITypeDMService extends IService<TypeDM> {

    //List<TypeDM> trouverTypeDMByDM(String  idDM);
    void addTypeDM(String code,String NomTypeDM);
    TypeDM trouverbyNom(String nomTypeDM);
    void createT(String code,String nomTypeDM);
    void supprimerTypeDM(String nomTypeDM);

}
