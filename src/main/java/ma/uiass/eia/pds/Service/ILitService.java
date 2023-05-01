package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.EtatLit;
import ma.uiass.eia.pds.Model.Lit;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ILitService extends IService<Lit>{

    List<Lit> afficherToutL(String nomService);
    public List<Espace> afficherToutE(String nomService);


    Long countOccupation(boolean occupation);
    void deleteLit(int idLitt);

    void update(int idLit, boolean occupee, int espacecode, EtatLit etatLit);
    Long countOccupationInEspace(int idEspace, boolean occupation);

    List<Lit> getLitByEsapce(int idEspace);
    Map<String, Integer> getNLDB();
    Map<String, Integer> getNLO();
    Lit findbycode(String codeLit);
}
