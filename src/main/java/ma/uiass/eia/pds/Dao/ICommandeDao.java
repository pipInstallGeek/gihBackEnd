package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Commande;
import ma.uiass.eia.pds.Model.EtatCommande;
import ma.uiass.eia.pds.Model.Marque;

import java.util.Date;
import java.util.List;

public interface ICommandeDao extends IDao<Commande> {
   void update(Commande commande);
   void deleteCommande(Commande commande);
   Commande getbycode(String numCommande);
    //List<Commande> getAll2();


}