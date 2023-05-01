package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DescriptionDMDao;
import ma.uiass.eia.pds.Dao.IDescriptionDMDao;
import ma.uiass.eia.pds.Dao.ITypeDMDao;
import ma.uiass.eia.pds.Dao.TypeDMDao;
import ma.uiass.eia.pds.Model.DispositifMedical;

import java.util.List;

public class DescriptionDMService implements IDescriptionDMService{
    IDescriptionDMDao descriptionDao=new DescriptionDMDao();
    ITypeDMDao typeDMDao=new TypeDMDao();
    @Override
    public void ajouter(DispositifMedical dispositifMedical) {descriptionDao.add(dispositifMedical);}
   /* @Override
    public void addDescriptionDM(String NomDM,int Quantité,String CodeTypeDM,String CodeESpace){
        TypeDM t=typeDMDao.findbyCode(CodeTypeDM);
        DescriptionDM dm=new DescriptionDM(NomDM,Quantité,t,null);
    }*/
    @Override
    public List<DispositifMedical> afficherTout() { return descriptionDao.getAll();}
    @Override
    public DispositifMedical trouverId(int id) {return descriptionDao.getById(id);}
    @Override
    public List<DispositifMedical> trouverDMByTypeDM(String  TypeDM) {
        List<DispositifMedical> Dms = descriptionDao.getDmByNomType(TypeDM);
        return Dms;
    }
    @Override
    public DispositifMedical trouverNom(String nom) {return descriptionDao.searchByNom(nom);}
}
