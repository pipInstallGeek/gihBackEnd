package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DemandeL;
import ma.uiass.eia.pds.Model.EtatDemandeL;
import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public interface IDemandeLDao extends IDao<DemandeL> {
    void deleteLit(DemandeL demandeL);

    DemandeL findByCode(String codeD);

    List<DemandeL> findByServie(int id);

    void updateEtat(DemandeL d, EtatDemandeL etat);
}
