package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DetailsDemandeDao;
import ma.uiass.eia.pds.Dao.IDetailsdemandeDao;
import ma.uiass.eia.pds.Model.DetailsDemande;

import java.util.List;

public class DetailsDemandeService implements IDetailsDemandeService{

    IDetailsdemandeDao detailsdemandeDao = new DetailsDemandeDao();
    @Override
    public void ajouter(DetailsDemande detailsDemande) {
        detailsdemandeDao.add(detailsDemande);
    }
    @Override
    public List<DetailsDemande> afficherTout() {
        return detailsdemandeDao.getAll();
    }

    @Override
    public DetailsDemande trouverId(int idDetailsDemande) {
        return detailsdemandeDao.getById(idDetailsDemande);
    }
}
