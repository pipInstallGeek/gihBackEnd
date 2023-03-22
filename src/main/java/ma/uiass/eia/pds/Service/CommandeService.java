package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.CommandeDao;
import ma.uiass.eia.pds.Dao.ICommandeDao;
import ma.uiass.eia.pds.Model.Commande;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CommandeService implements ICommandeService{

    ICommandeDao commandeDao = new CommandeDao();
    @Override
    public void modifier(Commande commande, Date dlc,boolean confirmation) {commandeDao.update(commande,dlc,confirmation);}
    @Override
    public void ajouter(Commande commande) {commandeDao.add(commande);}
    @Override
    public List<Commande> afficherTout() {return commandeDao.getAll();}
    @Override
    public Commande trouverId(int id) {return commandeDao.getById(id);}
}
