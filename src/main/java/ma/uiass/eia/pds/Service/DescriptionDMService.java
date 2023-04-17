package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DescriptionDMDao;
import ma.uiass.eia.pds.Dao.IDescriptionDMDao;
import ma.uiass.eia.pds.Dao.ITypeDMDao;
import ma.uiass.eia.pds.Dao.TypeDMDao;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class DescriptionDMService implements IDescriptionDMService{
    IDescriptionDMDao descriptionDao=new DescriptionDMDao();
    ITypeDMDao typeDMDao=new TypeDMDao();
    @Override
    public void ajouter(DescriptionDM descriptionDM) {descriptionDao.add(descriptionDM);}
   /* @Override
    public void addDescriptionDM(String NomDM,int Quantité,String CodeTypeDM,String CodeESpace){
        TypeDM t=typeDMDao.findbyCode(CodeTypeDM);
        DescriptionDM dm=new DescriptionDM(NomDM,Quantité,t,null);
    }*/
    @Override
    public List<DescriptionDM> afficherTout() { return descriptionDao.getAll();}
    @Override
    public DescriptionDM trouverId(int id) {return descriptionDao.getById(id);}
    @Override
    public List<DescriptionDM> trouverDMByTypeDM(String  TypeDM) {
        List<DescriptionDM> Dms = descriptionDao.getDmByNomType(TypeDM);
        return Dms;
    }
}
