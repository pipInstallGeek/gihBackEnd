package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ITypeLitDao;
import ma.uiass.eia.pds.Dao.TypeLitDao;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.TypeLit;

import java.util.List;

public class TypeLitService implements ITypeLitService{
    ITypeLitDao typeLitDao = new TypeLitDao();
    @Override
    public void ajouter(TypeLit typeLit) {
        typeLitDao.add(typeLit);
    }

    @Override
    public List<TypeLit> afficherTout() {
        return typeLitDao.getAll();
    }

    @Override
    public TypeLit trouverId(int id) {
        return typeLitDao.getById(id);
    }
}