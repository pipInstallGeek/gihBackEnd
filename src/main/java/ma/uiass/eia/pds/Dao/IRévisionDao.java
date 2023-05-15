package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Révision;

import java.util.List;

public interface IRévisionDao extends IDao<Révision> {
    List<Révision> findbyCde(String codeAmbulance);
}
