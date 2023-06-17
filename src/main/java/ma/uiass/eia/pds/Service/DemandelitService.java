package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.DemandeLit;
import ma.uiass.eia.pds.Model.EtatDemande;
import ma.uiass.eia.pds.Model.Service;

import java.util.Date;
import java.util.List;

public class DemandelitService implements IDemandelitService {

    private DemandelitDao daoD = new DemandelitDao();
    private IServiceDao daoS = new ServiceDao();
    @Override
    public void create(String code, String nomS){
        Date currentDate = new Date();
        daoD.add(new DemandeLit(code,currentDate,daoS.findByName(nomS), EtatDemande.ENCOURS));
    }
    @Override
    public List<DemandeLit> getAll(){return daoD.getAll();}

    @Override
    public List<DemandeLit> getAllByService(Service service){return daoD.getAllByService(service);}

    @Override
    public DemandeLit findBycode(String code ){return daoD.findByCode(code);}
    @Override
    public void modifierT(String code) {
        daoD.updateT(daoD.findByCode(code));
    }
    @Override
    public void modifierR(String code) {daoD.updateR(daoD.findByCode(code));}
}
