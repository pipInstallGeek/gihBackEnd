package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Révision;

import java.util.List;

public interface IRévisionDao extends IDao<Révision> {
    List<Révision> findbyCde(String codeAmbulance);
    void updateS(Révision r,String dateS);
    Révision findbyCode(String codeRévision);
    void updateState(Révision r,String Newstate);
    List<Révision> findbyDateSNull(String codeAmbulance);
}
