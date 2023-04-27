package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;

import java.util.List;

public interface IDetailsLivraisonService extends IService<DetailsLivraison> {


    List<DetailsLivraison> getbyLivraison(int idLivraisonFournisseur);

}
