package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.DetailDemandeLit;

import java.util.List;

public class DetailDemandelitService implements IDetailDemandelitService {
    DetailDemandelitDao daoDD = new DetailDemandelitDao();
    DemandelitDao daoD = new DemandelitDao();
    @Override
    public void create(String code, int quantite, String typelit, String marque){
        DetailDemandeLit d = new DetailDemandeLit(code,quantite,typelit,  marque);
        daoDD.add(d);
    }

    @Override
    public void deleteBycode(String code){daoDD.delete(daoDD.findByCode(code));}
    @Override
    public void update(String codeDD,String codeD){ daoDD.update(daoDD.findByCode(codeDD),daoD.findByCode(codeD));}
    @Override
    public  DetailDemandeLit getByCode(String code){return daoDD.findByCode(code);}
    @Override
    public void updateqt(String code, int q){daoDD.updateqt(daoDD.findByCode(code),q);}
    @Override
    public List<DetailDemandeLit> listDetailDemande(String code){
        return daoDD.findByidDemande(daoD.findByCode(code).getDemandelit_id());
    }
}
