package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class DescriptionDMService implements IDescriptionDMService{
    DescriptionDM DD=new DescriptionDM();
    IDescriptionDMDao descriptionDao=new DescriptionDMDao();
    ITypeDMDao typeDMDao=new TypeDMDAO();
    IEspaceDao salle=new SalleDao();
    IEspaceDao chambre =new ChambreDao();
    @Override
    public void ajouter(DescriptionDM descriptionDM) {descriptionDao.add(descriptionDM);}
   @Override
    public void addDescriptionDM(String NomDM,int Quantité,String NomTypeDM,String CodeESpace){
        TypeDM t=typeDMDao.findbyNom(NomTypeDM);
        char s='S';
            if (CodeESpace.charAt(0)==s){
              Espace  s1= salle.findbyCode(CodeESpace);
              DescriptionDM old1= descriptionDao.findbyNom(NomDM);
              DescriptionDM d1=new DescriptionDM(NomDM,Quantité,t, s1);
                descriptionDao.add(d1);
                d1.setNomDM(NomDM+CodeESpace);
                System.out.println(d1.getNomDM());
                if(old1.getQuantité()>=Quantité) {
                    old1.setQuantité(old1.getQuantité() - Quantité);
                }
            }
          else {
                Espace  c1= chambre.findbyCode(CodeESpace);
                DescriptionDM old2= descriptionDao.findbyNom(NomDM);
                DescriptionDM d2=new DescriptionDM(NomDM,Quantité,t, c1);
                descriptionDao.add(d2);
                d2.setNomDM(NomDM+CodeESpace);
                System.out.println(d2.getNomDM());
                if(old2.getQuantité()>=Quantité) {
                    old2.setQuantité(old2.getQuantité() - Quantité);
                }
            }
    }
    @Override
    public void create(String nomDM, int quantité,String typeDM){
        TypeDM t=typeDMDao.findbyNom(typeDM);
        descriptionDao.Create(new DescriptionDM(nomDM,0,t));
    }
    @Override
    public List<DescriptionDM> afficherTout() { return descriptionDao.getAll();}
    @Override
    public DescriptionDM trouverId(int id) {return descriptionDao.getById(id);}
    @Override
    public List<DescriptionDM> trouverDMByTypeDM(String  TypeDM) {
        List<DescriptionDM> Dms = descriptionDao.getDmByNomType(TypeDM);
        return Dms;
    }
    @Override
    public DescriptionDM trouverbyNom(String nomDM) {
        return descriptionDao.findbyNom(nomDM);
    }
    @Override
   public  int trouverQuantitéByDM(String nomDM){
        DescriptionDMDao descriptionDMDao=new DescriptionDMDao();
        return descriptionDMDao.getQuantitéByDM(nomDM);
    }
}
