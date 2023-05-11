package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IRevisionDao;
import ma.uiass.eia.pds.Dao.RevisionDao;
import ma.uiass.eia.pds.Model.Revision;

import java.util.List;

public class RevisionService implements IRevisionService{
    private IRevisionDao revisionDao = new RevisionDao();
    @Override
    public void ajouter(Revision revision) {
        revisionDao.add(revision);
    }

    @Override
    public List<Revision> afficherTout() {
        return revisionDao.getAll();
    }

    @Override
    public Revision trouverId(int idRevision) {
        return revisionDao.getById(idRevision);
    }
}
