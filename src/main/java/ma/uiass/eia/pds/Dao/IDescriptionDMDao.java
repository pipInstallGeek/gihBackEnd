package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public interface IDescriptionDMDao extends IDao<DescriptionDM> {
    List<DescriptionDM> getDmByNomType(String NomTypeDM);
    DescriptionDM findbyNom(String nomDM);
    void Create(DescriptionDM d);
    int getQuantitéByDM(String nomDM);
    void  deleteDM(DescriptionDM d);
    void updateNomDM(DescriptionDM d,String newNomDM);
    List<DescriptionDM> getAllByService(Service service);
}
