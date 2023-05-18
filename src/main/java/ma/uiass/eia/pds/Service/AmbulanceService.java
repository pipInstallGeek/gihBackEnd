package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.*;

import javax.enterprise.inject.New;
import java.time.LocalDate;
import java.util.List;

public class AmbulanceService implements IAmbulanceService {
    IAmbulanceDao ambulanceDao=new AmbulanceDao();
    IStateAMBDao stateAMBDao=new StateFDao();
    IStateAMBDao stateNFCDDao=new StateNFCDDao();
    IStateAMBDao stateNFCLDao=new StateNFLDDao();


    @Override
    public void ajouter(Ambulance ambulance) {
        ambulance.setState((StateAMB) stateAMBDao.getById(52));
        ambulanceDao.add(ambulance);



    }

    @Override
    public List<Ambulance> afficherTout() {return ambulanceDao.getAll();}

    @Override
    public Ambulance trouverId(int id) {return ambulanceDao.getById(id);}
    @Override
    public Ambulance trouverByCode(String code) {return ambulanceDao.findbyCode(code);}
    @Override
    public void addAMB(String dateMiseEnCirculation) {
        Ambulance ambulance = new Ambulance(dateMiseEnCirculation,LocalDate.now().toString(),0);
        ambulanceDao.add(ambulance);
        System.out.println(ambulance.getIdAmbulance());
        System.out.println(ambulance.getCodeAmbulance());

    }
    @Override
    public void modifierS(String codeAMB,String NewState) {
        Ambulance ambulance= ambulanceDao.findbyCode(codeAMB);
        if(NewState.equals("Non-Fonctionnelle-CD")){
            StateNFCD state= (StateNFCD) stateNFCDDao.findbyNom(NewState);
            ambulanceDao.updateState(ambulance,state);
        }
        else {
            StateNFLD state= (StateNFLD) stateNFCLDao.findbyNom(NewState);
            ambulanceDao.updateState(ambulance,state);
        }
    }
    @Override
    public void modifierK(String codeAMB,double NewKilo) {
        Ambulance ambulance= ambulanceDao.findbyCode(codeAMB);
        ambulanceDao.updateS(ambulance,NewKilo);
    }


}
