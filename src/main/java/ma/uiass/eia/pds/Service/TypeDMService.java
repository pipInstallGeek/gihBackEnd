package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ITypeDMDao;
import ma.uiass.eia.pds.Dao.TypeDMDao;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class TypeDMService implements ITypeDMService {
    ITypeDMDao type=new TypeDMDao();
    IDescriptionDMService d=new DescriptionDMService();
    TypeDM typeDM=new TypeDM();
    @Override
    public void ajouter(TypeDM typeDM) {type.add(typeDM);}
    @Override
    public void addTypeDM(String NomTypeDM){
        TypeDM typedm=new TypeDM(NomTypeDM);
        type.add((typedm));
    }

    @Override
    public TypeDM trouverbyNom(String nomTypeDM) {
        return type.findbyNom(nomTypeDM);
    }

    @Override
    public List<TypeDM> afficherTout() {return type.getAll();}
    @Override
    public TypeDM trouverId(int id) {return type.getById(id);}

   /* @Override
    public List<TypeDM> trouverTypeDMByDM(String  NomDM) {
        DescriptionDM dm=new DescriptionDM();
                List<TypeDM> typeDms = type.getTypeDmByNomDm(NomDM);
        return typeDms;
    }*/
   @Override
   public void createT(String nomTypeDM){
       type.createT(new TypeDM(nomTypeDM));
   }
    @Override
    public void supprimerTypeDM(String nomTypeDM) {
        TypeDM type1 = type.findbyNom(nomTypeDM);
        if (type1.getDMs() == null) {
            type.deleteTypeDM(type.findbyNom(nomTypeDM));
        }
    }
    public void modifier(String ancienNomTypeDM, String nouveauNomTypeDM) {
        TypeDM typeDM = type.findbyNom(ancienNomTypeDM);
        if (typeDM != null) {
            typeDM.setNomTypeDM(nouveauNomTypeDM);
            type.updateNomTypeDM(typeDM,nouveauNomTypeDM);
        }
    }

}
