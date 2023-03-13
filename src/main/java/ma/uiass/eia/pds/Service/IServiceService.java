package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public interface IServiceService {

    void ajouterService(Service service);

    List<Service> afficherServices();

    Service trouverServiceId(int id);
}
