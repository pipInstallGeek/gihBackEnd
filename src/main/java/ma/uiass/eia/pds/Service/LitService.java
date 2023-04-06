package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.*;

import java.util.List;

public class LitService implements ILitService{
    private ILitDao litDao = new LitDao();
    private IEspaceDao<Chambre> chambreservice = new ChambreDao();
    private IEspaceDao<Salle> salleservice = new SalleDao();

    @Override
    public void ajouter(Lit lit) {
        litDao.add(lit);
    }

    @Override
    public List<Lit> afficherTout() {
        return litDao.getAll();
    }

    @Override
    public Lit trouverId(int id) {return litDao.getById(id);}


    @Override
    public Long countOccupation(boolean occupation) {
        Long mycount = litDao.countOccupation(occupation);
        return mycount;
    }

    @Override
    public void deleteLit(int idLit) {
        Lit lit = litDao.getById(idLit);
        if (lit != null){
            litDao.deleteLit(lit);
        }
    }

    @Override
    public void update(int idLit,boolean occupee, int espacecode, EtatLit etatLit) {
        Lit lit = litDao.getById(idLit);
        Espace espace = chambreservice.getById(espacecode);
        if (espace == null){
            espace = salleservice.getById(espacecode);
        }
        litDao.update(lit,occupee, espace, etatLit);
    }
}
