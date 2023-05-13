package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Révision;
import ma.uiass.eia.pds.Model.TypeRévision;

public interface IRévisionService extends IService<Révision> {
    void addR(String dateR, String codeAMB, String dateProRévision, TypeRévision typeR);
}
