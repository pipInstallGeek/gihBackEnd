package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Salle;
import ma.uiass.eia.pds.Model.Service;

public interface IServiceDao extends IDao<Service> {
    Salle getStock(int idService);





}
