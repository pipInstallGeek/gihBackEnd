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
    IStocksDetailsService stocksDetailsService=new StocksDetailsService();
    IStocksDetailsDao stocksDetailsDao=new StocksDetailsDao();

    @Override
    public void ajouter(DispositifMedical dispositifMedical) {descriptionDao.add(dispositifMedical);}
   @Override
    public void addDescriptionDM(String NomDM,int Quantité,String NomTypeDM,String CodeESpace){
        TypeDM t=typeDMDao.findbyNom(NomTypeDM);
        char s='S';
            if (CodeESpace.charAt(0)==s){
                IStockService stockService=new StockService();
                Espace  s1= salle.findbyCode(CodeESpace);
                String nomService= s1.getService().getNomService();
                StocksDetails stock1=stocksDetailsService.getStockDetailsByNomDMAndService(NomDM,nomService);

                //  StocksDetails oldstock=stocksDetailsDao.getByDispoMedical(old1);
                //List<StocksDetails> stocks= stocksDetailsService.getByStock(stockService.getidStockbyname(nomService));
                DispositifMedical d1=new DispositifMedical(NomDM,Quantité,t, s1);
                d1.setNomDM(NomDM+CodeESpace.substring(0,3));
                int Q=stock1.getQuantity();
                descriptionDao.add(d1);
                //stock1.setQuantity(stock1.getQuantity()-Quantité);
                System.out.println(d1.getNomDM());
              //oldstock.setQuantity(oldstock.getQuantity() - Quantité);
             // descriptionDao.add(d1);
             // System.out.println(d1.getNomDM());


            }
          else {
                IStockService stockService=new StockService();
                Espace  c1= chambre.findbyCode(CodeESpace);
                String nomService= c1.getService().getNomService();
                //int quantity=stocksDetailsService.getDeviceStockQuantity(NomDM,nomService);
                //DispositifMedical old1= descriptionDao.findbyNom(NomDM);
                StocksDetails stock1=stocksDetailsService.getStockDetailsByNomDMAndService(NomDM,nomService);

                //  StocksDetails oldstock=stocksDetailsDao.getByDispoMedical(old1);
                //List<StocksDetails> stocks= stocksDetailsService.getByStock(stockService.getidStockbyname(nomService));
                DispositifMedical d1=new DispositifMedical(NomDM,Quantité,t, c1);
                d1.setNomDM(NomDM+CodeESpace.substring(0,3));
               int Q=stock1.getQuantity();
                descriptionDao.add(d1);
                //stock1.setQuantity(stock1.getQuantity()-Quantité);
                System.out.println(d1.getNomDM());
            }
    }
    @Override
    public void create(String nomDM, int quantité,String typeDM){
        TypeDM t=typeDMDao.findbyNom(typeDM);
        descriptionDao.Create(new DispositifMedical(nomDM,0,t));
        DD.setCodeDM(t.getCodeTypeDM().substring(0,3) + nomDM.substring(0,3));
        stocksDetailsService.ajouterS(nomDM,"logistique",0);
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
    @Override
    public void updateqt(String code ,int q){descriptionDao.updateqt(descriptionDao.findbyNom(code),q);}
}
