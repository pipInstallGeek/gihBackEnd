package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public interface ITypeDMService extends IService<TypeDM> {

    //List<TypeDM> trouverTypeDMByDM(String  idDM);
    void addTypeDM(String NomTypeDM);
    TypeDM trouverbyNom(String nomTypeDM);
    void createT(String nomTypeDM);
    void supprimerTypeDM(String nomTypeDM);
    void modifier(String ancienNomTypeDM, String nouveauNomTypeDM);

}
