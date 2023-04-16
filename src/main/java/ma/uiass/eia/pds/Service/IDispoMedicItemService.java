package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DispoMedicItem;

public interface IDispoMedicItemService extends IService<DispoMedicItem> {
     void deleteItem(int id);

}
