package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Fournisseur;

public interface IFournisseurService extends IService<Fournisseur>{
    public void updateFournisseurService(int idFournissuer, String nom, String email, String telephone, String adresse);
}
