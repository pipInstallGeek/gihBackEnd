package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Demande;
import ma.uiass.eia.pds.Model.EtatDemande;

public interface IDemandeService extends IService<Demande> {
    void modifier(String code);
    void modifier2(String code);
    void supprimerDemande(String numDemande);

    void ajouter(String NumDemande, int QteT, String dateDemande, String dateLivraison, String codeTypelit, String codeMarque, EtatDemande etat, String service);
}
