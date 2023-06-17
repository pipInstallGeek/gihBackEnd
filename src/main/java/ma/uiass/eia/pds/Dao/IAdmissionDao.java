package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Admission;
import ma.uiass.eia.pds.Model.Service;

import java.util.Date;
import java.util.List;

public interface IAdmissionDao extends IDao<Admission> {
    Admission findbyCode(String NumAdmission);

    void update(Admission admission);
    List<Admission> getAllByService(Service service);
}
