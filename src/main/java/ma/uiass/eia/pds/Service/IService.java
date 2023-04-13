package ma.uiass.eia.pds.Service;

import java.util.List;

public interface IService<T>{

    void ajouter(T t);
    List<T>  afficherTout();
    T trouverId(int id);

}
