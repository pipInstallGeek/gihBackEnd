package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ITypeDMDao;
import ma.uiass.eia.pds.Dao.TypeDMDao;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class TypeDMService implements ITypeDMService {
    ITypeDMDao type=new TypeDMDao();
    TypeDM typeDM=new TypeDM();
    @Override
    public void ajouter(TypeDM typeDM) {type.add(typeDM);}
    @Override
    public void addTypeDM(String code,String nomTypeDM){
        type.add(new TypeDM(code,nomTypeDM));
    }

    @Override
    public TypeDM trouverbyNom(String nomTypeDM) {
        return type.findbyNom(nomTypeDM);
    }

    @Override
    public List<TypeDM> afficherTout() {return type.getAll();}
    @Override
    public TypeDM trouverId(int id) {return type.getById(id);}


   @Override
   public void createT(String code,String nomTypeDM){
       type.createT(new TypeDM(code,nomTypeDM));
   }
    @Override
    public void supprimerTypeDM(String nomTypeDM) {
        TypeDM type1 = type.findbyNom(nomTypeDM);
        if (type1 == null) {
            type.deleteTypeDM(type.findbyNom(nomTypeDM));
        }
    }

}
