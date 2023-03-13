package ma.uiass.eia.pds.Service;
import ma.uiass.eia.pds.Dao.ChambreDao;

import ma.uiass.eia.pds.Dao.IChambreDao;
import ma.uiass.eia.pds.Model.Chambre;

import java.util.List;

public class ChambreService implements IChambreService {
    private IChambreDao chambreDao = new ChambreDao();

    @Override
    public void ajouterChambre(Chambre chambre) {
        chambreDao.add(chambre);

    }

    @Override
    public List<Chambre> afficheChambres() {

        return chambreDao.getAll();
    }

    @Override
    public Chambre trouverChambre(int id) {
        return chambreDao.getById(id);
    }
}
