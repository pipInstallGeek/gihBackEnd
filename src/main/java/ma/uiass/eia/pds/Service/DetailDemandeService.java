package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DemandeDao;
import ma.uiass.eia.pds.Dao.DetailDemandeDao;
import ma.uiass.eia.pds.Dao.ServiceDao;
import ma.uiass.eia.pds.Model.DetailDemande;

import java.util.List;

public class DetailDemandeService implements IDetailDemandeService{
    private DetailDemandeDao daoDD= new DetailDemandeDao();
    private ServiceDao daoS = new ServiceDao();
    private DemandeDao daoD = new DemandeDao();

    @Override
    public void ajouter(  String DM,int quantite){
        DetailDemande d = new DetailDemande(DM,quantite);
        daoDD.add(d);
    }
    @Override
    public void supprimer(String codeDD) {
        daoDD.delete(daoDD.findByCode(codeDD));}

    @Override
    public List<DetailDemande> afficherTout(){return daoDD.getAll();}

    @Override
    public void update(String codeDD,String codeD){ daoDD.update(daoDD.findByCode(codeDD),daoD.getbycode(codeD));}

    @Override
    public DetailDemande trouverId(int id) {
        return null;
    }
}
