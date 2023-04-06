package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.CommandeDao;
import ma.uiass.eia.pds.Dao.ICommandeDao;
import ma.uiass.eia.pds.Model.Commande;
import ma.uiass.eia.pds.Model.EtatCommande;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CommandeService implements ICommandeService{

    ICommandeDao commandeDao = new CommandeDao();
    IMarqueService marqueDao = new MarqueService();
    ITypeLitService typedao = new TypeLitService();
    /* @Override
     public void modifier(Commande commande, Date dlc,boolean confirmation) {commandeDao.update(commande,dlc,confirmation);}*/
    @Override
    public void ajouter(Commande commande) {commandeDao.add(commande);}



    @Override
    public List<Commande> afficherTout() {return commandeDao.getAll();}

    @Override
    public Commande trouverId(int id) {return commandeDao.getById(id);}

    @Override
    public void modifier(String code) {
        commandeDao.update(commandeDao.getbycode(code));
    }

    @Override
    public void supprimerCommande(String numCommande) { commandeDao.deleteCommande(commandeDao.getbycode(numCommande));}


    @Override
    public void ajouter(String numCommande, int quantite, String dateCommande, String dateLivraison, String typelit, String marque, EtatCommande etat) {
        Commande c = new Commande(numCommande,quantite,dateCommande,dateLivraison,typelit,marque,etat);
        commandeDao.add(c);
    }
}
