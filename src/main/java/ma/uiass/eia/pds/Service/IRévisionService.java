package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Révision;
import ma.uiass.eia.pds.Model.TypeRévision;

import java.util.List;

public interface IRévisionService extends IService<Révision> {
    void addR(String dateR,String dateSortie,double kilométrage, String codeAMB, String dateProRévision, TypeRévision typeR);
    List<Révision> trouverbyCode(String codeAMB);
    void modifierDateS(String codeR,String dateS);
    void addRSansDateS(String dateR,double kilométrage, String codeAMB,  TypeRévision typeR);
    void modifierState(String codeR,String NewState);
    List<Révision> trouverbyDateSNull(String codeAMB);
}
