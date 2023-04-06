package ma.uiass.eia.pds.Service;
import ma.uiass.eia.pds.Model.Admission;
import java.util.Date;
public interface IAdmissionService extends IService<Admission>  {
    //void addAdmission(String numAdmission,String dateE, String dateS, String codeLit);
    void addAdmission(String numAdmission,String dateE,  String codeLit);
    void updateAdmission(String numAdmission, String dateS);
    Admission findbycode(String NumAdmission);
    //void modifier(Admission s, Date dateFin, boolean estannulée);
    //List<Reservation> afficheHistorique(String numPatient);
}
