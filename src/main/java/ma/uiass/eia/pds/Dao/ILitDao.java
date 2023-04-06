package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public interface ILitDao extends IDao<Lit> {
    List<Lit> getAvailableLit(String nomService, String typeEspace);
    Lit findbyCode(String code);


}