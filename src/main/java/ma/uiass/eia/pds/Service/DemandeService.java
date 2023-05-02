package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DemandeDao;
import ma.uiass.eia.pds.Dao.IDemandeDao;
import ma.uiass.eia.pds.Model.Demande;

import java.util.List;

public class DemandeService implements IDemandeService{

    private IDemandeDao demandeDao = new DemandeDao();
    @Override
    public void ajouter(Demande demande) {
        demandeDao.add(demande);
    }

    @Override
    public List<Demande> afficherTout() {
        return demandeDao.getAll();
    }

    @Override
    public Demande trouverId(int idDemande) {
        return demandeDao.getById(idDemande);
    }
}
