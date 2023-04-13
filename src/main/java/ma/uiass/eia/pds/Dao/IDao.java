package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.DemandeL;
import ma.uiass.eia.pds.Model.DetailDemandeL;

import java.util.List;

public interface IDao<T > {
    List<T> getAll();

    void    add(T t);

    T getById(int id);

}