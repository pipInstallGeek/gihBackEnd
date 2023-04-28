package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ITypeDMDao;
import ma.uiass.eia.pds.Dao.TypeDMDAO;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class TypeDmService implements ITypeDmService {

    private ITypeDMDao typeDmDAO=new TypeDMDAO();


    @Override
    public void ajouter(TypeDM typeDM) {
        typeDmDAO.add(typeDM);
    }


    @Override
    public List<TypeDM> afficherTout() {
        return typeDmDAO.getAll();
    }

    @Override
    public TypeDM trouverId(int id) {
        return typeDmDAO.getById(id);
    }
}
