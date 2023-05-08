package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DispositifMedical;

import java.util.List;

public interface IDescriptionDMService extends IService<DispositifMedical> {
    List<DispositifMedical> trouverDMByTypeDM(String  TypeDM);
    void addDescriptionDM(String NomDM,int Quantité,String NomTypeDM,String CodeESpace);
    DispositifMedical trouverbyNom(String nomDM);
    void create( String nomDM, int quantité,String typeDM);
    int trouverQuantitéByDM(String nomDM);
    public void supprimerDM(String nomDM);
    void modifier(String ancienNomDM, String nouveauNomDM);
    List<DispositifMedical> afficherToutParService(String nomService);
    DispositifMedical trouverNom(String nom);
    void updateqt(String code ,int q);
}
