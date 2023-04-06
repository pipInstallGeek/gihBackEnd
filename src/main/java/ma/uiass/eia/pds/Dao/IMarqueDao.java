package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Marque;

public interface IMarqueDao extends IDao<Marque> {
     Marque getByCode(String codeMarque);
}
