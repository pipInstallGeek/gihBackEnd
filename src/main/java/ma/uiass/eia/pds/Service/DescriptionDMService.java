package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.*;
import ma.uiass.eia.pds.Model.*;

import java.util.List;

public class DescriptionDMService implements IDescriptionDMService{
    DispositifMedical DD=new DispositifMedical();
    IDescriptionDMDao descriptionDao=new DescriptionDMDao();
    ITypeDMDao typeDMDao=new TypeDMDao();
    IEspaceDao salle=new SalleDao();
    IEspaceDao chambre =new ChambreDao();
    IServiceDao serviceDao=new ServiceDao();

    @Override
    public void ajouter(DispositifMedical dispositifMedical) {descriptionDao.add(dispositifMedical);}
   @Override
    public void addDescriptionDM(String NomDM,int Quantité,String NomTypeDM,String CodeESpace){
        TypeDM t=typeDMDao.findbyNom(NomTypeDM);
        char s='S';
            if (CodeESpace.charAt(0)==s){
              Espace  s1= salle.findbyCode(CodeESpace);
              DispositifMedical old1= descriptionDao.findbyNom(NomDM);
              DispositifMedical d1=new DispositifMedical(NomDM,Quantité,t, s1);
              d1.setNomDM(NomDM+CodeESpace);
                old1.setQuantité(old1.getQuantité() - Quantité);
              descriptionDao.add(d1);
              System.out.println(d1.getNomDM());


            }
          else {
                Espace  c1= chambre.findbyCode(CodeESpace);
                DispositifMedical old2= descriptionDao.findbyNom(NomDM);
                System.out.println(old2);
                DispositifMedical d2=new DispositifMedical(NomDM,Quantité,t, c1);
                d2.setNomDM(NomDM+CodeESpace);
                old2.setQuantité(old2.getQuantité() - Quantité);


                descriptionDao.add(d2);
                System.out.println(d2.getNomDM());

            }
    }
    @Override
    public void create(String nomDM, int quantité,String typeDM){
        TypeDM t=typeDMDao.findbyNom(typeDM);
        descriptionDao.Create(new DispositifMedical(nomDM,0,t));
    }
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
    public DispositifMedical trouverbyNom(String nomDM) {
        return descriptionDao.findbyNom(nomDM);
    }
    @Override
   public  int trouverQuantitéByDM(String nomDM){
        DescriptionDMDao descriptionDMDao=new DescriptionDMDao();
        return descriptionDMDao.getQuantitéByDM(nomDM);
    }
    @Override
    public void supprimerDM(String nomDM) {
        DispositifMedical dispositifMedical = descriptionDao.findbyNom(nomDM);
        if (dispositifMedical.getQuantité() == 0) {
            descriptionDao.deleteDM(descriptionDao.findbyNom(nomDM));
        }
    }
    public void modifier(String ancienNomDM, String nouveauNomDM) {
        DispositifMedical descriptionDM = descriptionDao.findbyNom(ancienNomDM);
            descriptionDao.updateNomDM(descriptionDM,nouveauNomDM);
    }
    @Override
    public List<DispositifMedical> afficherToutParService(String nomService) {
        Service service=serviceDao.findbyNom(nomService);
        return descriptionDao.getAllByService(service);
    }

    @Override
    public DispositifMedical trouverNom(String nom) {
        return descriptionDao.findbyNom(nom);
    }
}
