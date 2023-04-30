package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Service;

public interface IServiceDao extends IDao<Service> {
    Service findbyNom(String nomService);






}
