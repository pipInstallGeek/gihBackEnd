package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Admission;

import java.util.Date;

public interface IAdmissionDao extends IDao<Admission> {
    Admission findbyCode(String NumAdmission);

    void update(Admission admission);
}
