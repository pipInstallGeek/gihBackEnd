package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Commande;

import java.util.Date;

public interface ICommandeDao extends IDao<Commande> {
    void update(Commande commande,Date dlc, boolean comfirmation);
}