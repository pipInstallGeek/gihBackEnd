package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.EtatLit;
import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public interface ILitDao extends IDao<Lit> {

    Long countOccupation(boolean occupe);
    Long countOccupationInEspace(Espace espace,boolean occupe);
    void deleteLit(Lit lit);

    void update(Lit lit, boolean occupee, Espace espace, EtatLit etatLit);
    List<Lit> getAvailableLit(String nomService);
    Lit findbyCode(String code);
    List<Espace> getEspaceByService(String nomService);

}