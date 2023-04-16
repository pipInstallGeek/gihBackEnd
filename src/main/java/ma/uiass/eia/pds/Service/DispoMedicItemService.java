package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DispoMedicItemDao;
import ma.uiass.eia.pds.Dao.IDispoMedicItemDao;
import ma.uiass.eia.pds.Model.DispoMedicItem;
import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public class DispoMedicItemService implements IDispoMedicItemService{

    IDispoMedicItemDao dispoMedicItemDao=new DispoMedicItemDao();

    @Override
    public void ajouter(DispoMedicItem dispoMedicItem) {
        dispoMedicItemDao.add(dispoMedicItem);
    }

    @Override
    public List<DispoMedicItem> afficherTout() {
        return dispoMedicItemDao.getAll();
    }

    @Override
    public DispoMedicItem trouverId(int id) {
        return dispoMedicItemDao.getById(id);
    }

    @Override
    public void deleteItem(int id){

        DispoMedicItem dispoMedicItem =dispoMedicItemDao.getById(id);
        if (dispoMedicItem != null) {
            dispoMedicItemDao.deleteDmItem(dispoMedicItem);
        }

    }
}
