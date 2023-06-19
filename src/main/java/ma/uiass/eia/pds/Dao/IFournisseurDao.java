package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Fournisseur;

public interface IFournisseurDao extends IDao<Fournisseur> {
    public void updateFournisseurCredentials(int idFournissuer, String nom, String email, String telephone, String adresse);

}
