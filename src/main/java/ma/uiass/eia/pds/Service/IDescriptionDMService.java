package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.DispositifMedical;

import java.util.List;

public interface IDescriptionDMService extends IService<DescriptionDM> {
    List<DescriptionDM> trouverDMByTypeDM(String  TypeDM);
    void addDescriptionDM(String NomDM,int Quantité,String NomTypeDM,String CodeESpace);
    DescriptionDM trouverbyNom(String nomDM);
    void create( String nomDM, int quantité,String typeDM);
    int trouverQuantitéByDM(String nomDM);
    public void supprimerDM(String nomDM);
    void modifier(String ancienNomDM, String nouveauNomDM);
    List<DescriptionDM> afficherToutParService(String nomService);
}
