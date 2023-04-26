package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Salle;

public interface IEspaceDao<T extends Espace> extends IDao<T> {
    Espace findbyCode(String codeEspace);



}