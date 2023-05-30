package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DispoMedicItem;

public interface IDispoMedicItemDao extends IDao<DispoMedicItem>{
    void deleteDmItem(DispoMedicItem dispoMedicItem);

     void updateEspace(int idItem, String espaceItem);

}
