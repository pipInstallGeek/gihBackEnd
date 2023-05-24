package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.*;

import java.util.List;

public class
RévisionService implements IRévisionService{
    IRévisionDao révisionDao=new RévisionDao();
    IAmbulanceDao ambulanceDao=new AmbulanceDao();
    IStateAMBDao stateFDao=new StateFDao();

    IAmbulanceService ambulanceService=new AmbulanceService();

    @Override
    public void ajouter(Révision révision) {
        révisionDao.add(révision);

    }

    @Override
    public List<Révision> afficherTout() {
        return révisionDao.getAll();
    }

    @Override
    public Révision trouverId(int id) {
        return révisionDao.getById(id);
    }
    @Override
    public void addR(String dateR,String dateSortie,double kilométrage, String codeAMB, String dateProRévision, TypeRévision typeR) {
        Ambulance ambulance=ambulanceService.trouverByCode(codeAMB);
        System.out.println(ambulance);
        String desc=codeAMB+"a été soumise à une "+typeR+"et elle est devenue";
        Révision r=new Révision(dateR, kilométrage,dateSortie,dateProRévision,desc,typeR,ambulance);
        révisionDao.add(r);
        //r.setCodeRévision("REV"+r.getIdRévision());
    }
    @Override
    public void addRSansDateS(String dateR,double kilométrage, String codeAMB,  TypeRévision typeR) {
        Ambulance ambulance=ambulanceService.trouverByCode(codeAMB);
        System.out.println(ambulance);
        String desc=codeAMB+" a été soumise à une "+typeR;
        Révision r=new Révision(dateR,typeR, kilométrage,ambulance,desc);
        révisionDao.add(r);
        //r.setCodeRévision("REV"+r.getIdRévision());
    }
    @Override
    public List<Révision> trouverbyCode(String codeAMB) {
        return révisionDao.findbyCde(codeAMB);
    }
    @Override
    public void modifierDateS(String codeR,String dateS) {
        Révision révision= révisionDao.findbyCode(codeR);
        StateF state= (StateF) stateFDao.findbyNom("F");
        révision.getAmbulance().setState(state);
        révisionDao.updateS(révision,dateS);

    }
    @Override
    public void modifierState(String codeR,String NewState) {
        Révision révision= révisionDao.findbyCode(codeR);
        révisionDao.updateState(révision,NewState);

    }
    @Override
    public List<Révision> trouverbyDateSNull(String codeAMB) {
        return révisionDao.findbyDateSNull(codeAMB);
    }
}
