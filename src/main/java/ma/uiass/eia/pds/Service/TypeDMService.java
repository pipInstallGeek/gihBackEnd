package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ITypeDMDao;
import ma.uiass.eia.pds.Dao.TypeDMDao;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class TypeDMService implements ITypeDMSerivce{
    private ITypeDMDao typeDMDao = new TypeDMDao();
    @Override
    public void ajouter(TypeDM typeDM) {
        typeDMDao.add(typeDM);
    }

    @Override
    public List<TypeDM> afficherTout() {
        return typeDMDao.getAll();
    }

    @Override
    public TypeDM trouverId(int id) {
        return typeDMDao.getById(id);
    }
}
