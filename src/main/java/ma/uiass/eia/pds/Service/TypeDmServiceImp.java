package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.TypeDmDAO;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class TypeDmServiceImp implements ITypeDmService {

    private TypeDmDAO typeDmDAO=new TypeDmDAO();
    @Override
    public void ajouterTypeDm(TypeDM typeDM) {typeDmDAO.add(typeDM);}

    @Override
    public List<TypeDM> afficherTypeDm() {
        return typeDmDAO.getAll();
    }
}
