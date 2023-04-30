package ma.uiass.eia.pds.Dao;

import java.util.List;

public interface IDao<T > {
    List<T> getAll();

    void    add(T t);

    T getById(int id);



}