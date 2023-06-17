package ma.uiass.eia.pds.Service;
import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.Admission;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Service;

import java.util.List;
public class AdmissionService implements IAdmissionService {
     IAdmissionDao admissionDao = new AdmissionDao();
     ILitDao litDao = new LitDao();
     IServiceDao se=new ServiceDao();
    AdmissionDao ad=new AdmissionDao();
    @Override
    public void ajouter(Admission admission) {
        admissionDao.add(admission);
    }
    @Override
    public List<Admission> afficherTout() {
        return admissionDao.getAll();
    }
    @Override
    public Admission trouverId(int id) {
        return admissionDao.getById(id);
    }
    public int afficgerIdMax(){return ad.getMaxAdmissionIdFromDatabase(); }
   /* public void addAdmission(String numAdmission,String dateE, String dateS, String codeLit) {
        Lit l=litDao.findbyCode(codeLit);
        Admission s= new Admission(numAdmission,dateE,dateS,litDao.findbyCode(codeLit));
        admissionDao.add(s);
}*/


  @Override
    public void addAdmission( String dateE,  String codeLit) {
        Lit l=litDao.findbyCode(codeLit);
        Admission s= new Admission(dateE,litDao.findbyCode(codeLit));
        s.setNumAdmission("ADM_"+s.getIdAdmission());
        admissionDao.add(s);

    }
    @Override
    public void updateAdmission(String numAdmission, String dateS) {
        Admission admission = admissionDao.findbyCode(numAdmission);
        if (admission != null) {
            admission.setDateFin(dateS);
            Lit lit = admission.getLit();
            if (lit != null) {
                lit.setOccupe(false); // Mark the bed as available
                //litDao.update(lit); // Update the bed in the database
            }
            admissionDao.update(admission); // Update the admission in the database
        }
    }
    @Override
    public Admission findbycode(String NumAdmission){
        return admissionDao.findbyCode(NumAdmission);
    }
    public List<Admission> getAdmissionByService(int idService ){
      Service s=se.getById(idService);
      return  admissionDao.getAllByService(s);
    }




}

