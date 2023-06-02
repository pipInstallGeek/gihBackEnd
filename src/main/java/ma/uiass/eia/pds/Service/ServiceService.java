package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IServiceDao;
import ma.uiass.eia.pds.Dao.ServiceDao;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Salle;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public class ServiceService implements IServiceService{

    IServiceDao serviceDao = new ServiceDao();
    @Override
    public void ajouter(Service service) {
         serviceDao.add(service);
    }

    @Override
    public List<Service> afficherTout() {
        return serviceDao.getAll();
    }

    @Override
    public Service trouverId(int id) {
        return serviceDao.getById(id);
    }

    public Salle getStock(int idService){
        return serviceDao.getStock(idService);
    }
}
