package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.*;

import java.time.LocalDate;
import java.util.List;

public class AmbulanceService implements IAmbulanceService {
    IAmbulanceDao ambulanceDao=new AmbulanceDao();
    IStateAMBDao stateAMBDao=new StateFDao();
    @Override
    public void ajouter(Ambulance ambulance) {ambulanceDao.add(ambulance);}

    @Override
    public List<Ambulance> afficherTout() {return ambulanceDao.getAll();}

    @Override
    public Ambulance trouverId(int id) {return ambulanceDao.getById(id);}
    @Override
    public Ambulance trouverByCode(String code) {
        //return ambulanceDao.findbyCode(code);
        return null;}
    @Override
    public void addAMB(String dateMiseEnCirculation) {
        StateAMB  etat=stateAMBDao.findbyNom("Fonctionnelle");
        Ambulance ambulance = new Ambulance(dateMiseEnCirculation,LocalDate.now().toString(),0,etat);
        ambulanceDao.add(ambulance);
        System.out.println(ambulance.getIdAmbulance());
        System.out.println(ambulance.getCodeAmbulance());

    }
    @Override
    public void modifierS(String codeAMB,String NewState) {
      /*  Ambulance ambulance= ambulanceDao.findbyCode(codeAMB);
        ambulanceDao.updateS(ambulance,NewState);

       */
    }


}
