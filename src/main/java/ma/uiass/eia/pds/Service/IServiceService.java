package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Salle;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;

public interface IServiceService extends IService<Service>{

    Salle getStock(int idService);
}
