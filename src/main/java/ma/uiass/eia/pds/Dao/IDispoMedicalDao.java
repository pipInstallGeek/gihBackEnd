package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DispositifMedical;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public interface IDispoMedicalDao extends IDao<DispositifMedical>{

    List<DispositifMedical> getbytype(TypeDM typeDM);

}
