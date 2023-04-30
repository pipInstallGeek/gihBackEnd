package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Admission;

public interface IAdmissionDao extends IDao<Admission> {
    //void update(Admission s, Date dateFin, boolean estannulée);
    Admission findbyCode(String NumAdmission);

    void update(Admission admission);
}
