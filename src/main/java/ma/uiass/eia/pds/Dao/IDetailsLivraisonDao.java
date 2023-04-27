package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;

import java.util.List;

public interface IDetailsLivraisonDao extends IDao<DetailsLivraison> {

    List<DetailsLivraison> getbyLivraison(LivraisonFournisseur livraisonFournisseur);
}
