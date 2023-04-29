package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Espace;


public interface IEspaceDao<T extends Espace> extends IDao<T> {
    Espace findbyCode(String codeEspace);



}
