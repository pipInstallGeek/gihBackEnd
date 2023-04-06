package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Commande;
import ma.uiass.eia.pds.Model.EtatCommande;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ICommandeService extends IService<Commande> {
    void modifier(String code);
    void supprimerCommande(String numCommande);


   // List<Commande> afficherTout2();

    void ajouter(String NumCommande, int QteT, String dateCT, String dateLT, String codeTypelit, String codeMarque, EtatCommande etat);
}

