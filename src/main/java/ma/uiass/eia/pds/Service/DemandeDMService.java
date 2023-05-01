package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DemandeDMDaoImp;
import ma.uiass.eia.pds.Dao.ServiceDao;
import ma.uiass.eia.pds.Model.DemandeDM;
import ma.uiass.eia.pds.Model.EtatDemande;
import ma.uiass.eia.pds.Model.Service;

import java.util.Date;
import java.util.List;

public class DemandeDMService implements IDemandeDMService{
    private DemandeDMDaoImp daoD = new DemandeDMDaoImp();
    private ServiceDao daoS = new ServiceDao();
    @Override
    public void create(String code,String nomS){
        Date currentDate = new Date();
        daoD.add(new DemandeDM(code,currentDate,daoS.findByName(nomS), EtatDemande.EnCours));
    }
    @Override
    public List<DemandeDM> getAll(){return daoD.getAll();}

    @Override
    public List<DemandeDM> getAllByService(Service service){return daoD.getAllByService(service);}

    @Override
    public DemandeDM findBycode(String code ){return daoD.findByCode(code);}
    @Override
    public void modifierT(String code) {
        daoD.updateT(daoD.findByCode(code));
    }
    @Override
    public void modifierR(String code) {daoD.updateR(daoD.findByCode(code));}
}

