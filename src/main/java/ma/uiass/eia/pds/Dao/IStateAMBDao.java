package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.StateAMB;

public interface IStateAMBDao<S extends StateAMB> extends IDao<S> {
    StateAMB findbyNom(String nomState);
}
