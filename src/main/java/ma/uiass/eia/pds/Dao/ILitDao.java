package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Lit;

public interface ILitDao extends IDao<Lit> {

    Long countOccupation(boolean occupe);

}