package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DemandeDao;
import ma.uiass.eia.pds.Dao.IDemandeDao;
import ma.uiass.eia.pds.Model.Demande;
import ma.uiass.eia.pds.Model.EtatDemande;

import java.util.List;

public class DemandeService implements IDemandeService {

    IDemandeDao Demandedao = new DemandeDao();
    IMarqueService marqueDao = new MarqueService();
    ITypeLitService typedao = new TypeLitService();
    @Override
    public void ajouter(Demande demande) {Demandedao.add(demande);}



    @Override
    public List<Demande> afficherTout() {return Demandedao.getAll();}

    @Override
    public Demande trouverId(int id) {return Demandedao.getById(id);}

    @Override
    public void modifier(String code) {
        Demandedao.update(Demandedao.getbycode(code));
    }
    @Override
    public void modifier2(String code) {Demandedao.updateR(Demandedao.getbycode(code));}
    @Override
    public void modifier3(String code){ Demandedao.update3(Demandedao.getbycode(code));}

    @Override
    public void supprimerDemande(String numDemande) { Demandedao.deleteCommande(Demandedao.getbycode(numDemande));}


    @Override
    public void ajouter(  String dateDemande,EtatDemande etat, String service) {
        Demande c = new Demande(dateDemande,etat,service);
        Demandedao.add(c);
}
}
