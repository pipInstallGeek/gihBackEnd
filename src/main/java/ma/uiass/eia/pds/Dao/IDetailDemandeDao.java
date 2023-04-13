package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DemandeL;
import ma.uiass.eia.pds.Model.DetailDemandeL;
import ma.uiass.eia.pds.Model.DetailLivraison;
import ma.uiass.eia.pds.Model.EtatDemandeL;

import java.util.List;

public interface IDetailDemandeDao extends IDao<DetailDemandeL> {

    void deleteLit(DetailDemandeL detaildemandeL);

    DetailDemandeL findByCode(String codeD);


    void update(DetailDemandeL d, DemandeL dem);
}
