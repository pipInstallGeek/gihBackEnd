package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DemandeLDao;
import ma.uiass.eia.pds.Dao.DetailDemandeDao;
import ma.uiass.eia.pds.Dao.LitDao;
import ma.uiass.eia.pds.Dao.ServiceDao;
import ma.uiass.eia.pds.Model.DemandeL;
import ma.uiass.eia.pds.Model.EtatDemandeL;

import java.util.Date;
import java.util.List;

public class DemandeLService {
    private DemandeLDao daoD = new DemandeLDao();
    private ServiceDao daoS = new ServiceDao();
    private LitDao daoL = new LitDao();
    private DetailDemandeDao daoDD = new DetailDemandeDao();
    public void addDemande( String code,String nomS, EtatDemandeL etat){
        Date currentDate = new Date();
        //DemandeL d=new DemandeL(code,currentDate,nomS,etat);
       // daoD.add(d);

    }
    public List<DemandeL> getAll(){return daoD.getAll();}
    public DemandeL findByCode(String code){return daoD.findByCode(code);}
    public List<DemandeL> getByService(String nomS){
        return null ; /*daoD.findByServie(daoS.findByName(nomS).getService_id());*/
    }
    //public void updateEtat(String code,EtatDemandel etat){daoD.updateEtat(daoD.findByCode(code),etat);}

}
