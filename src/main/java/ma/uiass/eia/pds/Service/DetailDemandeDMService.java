package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DemandeDMDaoImp;
import ma.uiass.eia.pds.Dao.DescriptionDMDao;
import ma.uiass.eia.pds.Dao.DetailDemandeDMDaoImp;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.DetailDemandeDM;

import java.util.List;

public class DetailDemandeDMService implements IDetailDemandeDMService{

         DetailDemandeDMDaoImp daoDD = new DetailDemandeDMDaoImp();
         DemandeDMDaoImp daoD = new DemandeDMDaoImp();
         DescriptionDMDao daoDM = new DescriptionDMDao();
        @Override
        public void create(String code,String nom, int quantite){
        DescriptionDM dm = daoDM.searchByNom(nom);
        DetailDemandeDM d = new DetailDemandeDM(code,quantite,dm);
        daoDD.add(d);
    }

        @Override
        public void deleteBycode(String code){daoDD.delete(daoDD.findByCode(code));}
        @Override
        public void update(String codeDD,String codeD){ daoDD.update(daoDD.findByCode(codeDD),daoD.findByCode(codeD));}
        @Override
        public  DetailDemandeDM getByCode(String code){return daoDD.findByCode(code);}
        @Override
        public void updateqt(String code ,int q){daoDD.updateqt(daoDD.findByCode(code),q);}
        @Override
        public List<DetailDemandeDM> listDetailDemande(String code){
        return daoDD.findByidDemande(daoD.findByCode(code).getDemandeDM_id());
    }
}
