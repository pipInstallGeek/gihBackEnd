package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Demande;

public interface IDemandeDao extends IDao<Demande> {
    void update(Demande demande);

    void updateR(Demande demande);

    void deleteCommande(Demande demande);
    Demande getbycode(String numDemande);
    //List<Commande> getAll2();


}
