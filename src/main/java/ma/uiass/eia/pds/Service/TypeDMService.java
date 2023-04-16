package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ITypeDMDao;
import ma.uiass.eia.pds.Dao.TypeDMDao;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class TypeDMService implements ITypeDMService {
    ITypeDMDao type=new TypeDMDao();
    @Override
    public void ajouter(TypeDM typeDM) {type.add(typeDM);}
    @Override
    public List<TypeDM> afficherTout() {return type.getAll();}
    @Override
    public TypeDM trouverId(int id) {return type.getById(id);}
}
